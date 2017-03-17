import com.restaurant.Application;
import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.helperModels.ChooserProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import util.MockedData;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Martha on 3/1/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@TestPropertySource(locations = "classpath:test.properties")
public class TestDAO {

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    private List<ChooserProduct> products1;
    private List<ChooserProduct> products2;

    @Before
    public void initRawEntities(){
        product1 = productService.createProduct(MockedData.productName(), MockedData.restaurantId());
        product2 = productService.createProduct(MockedData.productName(), MockedData.restaurantId());
        product3 = productService.createProduct(MockedData.productName(), MockedData.restaurantId());
        product4 = productService.createProduct(MockedData.productName(), MockedData.restaurantId());
        product5 = productService.createProduct(MockedData.productName(), MockedData.restaurantId());

        products1 = new LinkedList<>();
        products1.add(new ChooserProduct(product1.getId(), 2));
        products1.add(new ChooserProduct(product2.getId(), 8));
        products1.add(new ChooserProduct(product3.getId(), 5));
        products2 = new LinkedList<>();
        products2.add(new ChooserProduct(product4.getId(), 20));
        products2.add(new ChooserProduct(product5.getId(), 0));
    }

    @Test
    public void testServices() {
        Assert.assertNotNull(productService);
        Assert.assertNotNull(reservationService);
    }


    @Test
    public void testProductService() {
        // Product is created
        Assert.assertNotNull(productService.findProduct(product1.getId()));

        // Product is read
        Assert.assertNotNull(productService.findProduct(product1.getId()));

        // Product is updated
        Product product2 = productService.updateProductName(product1.getId(), MockedData.productName());
        Assert.assertEquals(product1.getId(), product2.getId());
        Assert.assertEquals(product1, product2);
        Assert.assertNotEquals(product1.getProductName(), product2.getProductName());

        // Product is deleted
        Assert.assertTrue(productService.deleteProduct(product1.getId()));
        Assert.assertNull(productService.findProduct(product1.getId()));


        // Product is deleted double times
        thrown.expect(Exception.class);
        productService.deleteProduct(product1.getId());
    }

    @Test
    public void createReservation(){
        // Reservation and products in reservation are created
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Assert.assertNotNull(reservationService.findReservationById(reservation1.getId()));


    }
    @Test
    public void addProductInReservation(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        // Products in reservation are created
        for (ProductInReservation productInReservation : reservation1.getProducts()) {
            Assert.assertNotNull(productInReservation.getId());
        }

        // A product in reservation is added
        reservation1 = reservationService.addProductInReservation(reservation1.getId(), product4.getId(), 15);
        Assert.assertEquals((long) reservation1.getProducts().size(), 4);
        Iterator iterator = reservation1.getProducts().iterator();
        ProductInReservation insertedProduct = null;
        while (iterator.hasNext()) {
            ProductInReservation temp = ((ProductInReservation) iterator.next());
            if (temp.getProduct().getId() == product4.getId()) {
                insertedProduct = temp;
                break;
            }
        }
        Assert.assertNotNull(insertedProduct);
    }

    @Test
    public void changeProductAmount(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        // Amount of product from reservation is changed
        ProductInReservation productWithInitialAmount = reservation1.getProducts().iterator().next();
        int initialAmount = productWithInitialAmount.getAmount();
        int productId = productWithInitialAmount.getId();
        reservation1 = reservationService.changeProductAmountInReservation(reservation1.getId(),
                productWithInitialAmount.getId(),
                productWithInitialAmount.getAmount() + 20);
        Iterator iterator = reservation1.getProducts().iterator();
        while (iterator.hasNext()) {
            ProductInReservation temp = ((ProductInReservation) iterator.next());
            if (temp.getId() == productId) {
                Assert.assertTrue(temp.getAmount() == initialAmount + 20);
                break;
            }
        }

    }
    @Test
    public void deleteProductFromReservation(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        // A product from reservation is deleted
        Iterator iterator = reservation1.getProducts().iterator();
        ProductInReservation productToBeDeleted = null;
        int counter = 0;
        while (iterator.hasNext()) {
            if (counter == 0) {
                productToBeDeleted = (ProductInReservation) iterator.next();
            }
            counter++;
        }
        reservationService.deleteProductFromReservation(reservation1.getId(), productToBeDeleted.getId());
        reservation1 = reservationService.findReservationById(reservation1.getId());
        iterator = reservation1.getProducts().iterator();
        ProductInReservation deletedProduct = null;
        while (iterator.hasNext()) {
            ProductInReservation temp = (ProductInReservation) iterator.next();
            if (temp.getId() == productToBeDeleted.getId()) {
                deletedProduct = (ProductInReservation) iterator.next();
            }
        }
        Assert.assertNull(deletedProduct);
    }

    @Test
    public void deleteReservation(){
        //Delete reservation
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products2, MockedData.restaurantId());
        Assert.assertEquals(reservation1.getProducts().size(), 1);

        ProductInReservation productInReservation = reservation1.getProducts().iterator().next();
        Assert.assertNotNull(productInReservation.getId());

        reservationService.changeReservationState(reservation1.getId(), false);
        reservationService.deleteReservation(reservation1.getId());

        Assert.assertNull(reservationService.findReservationById(reservation1.getId()));
    }

    @Test
    public void readReservationLazy(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2, MockedData.restaurantId());
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products2, MockedData.restaurantId());

        List<Reservation> reservations = reservationService.findAllReservations();
        Assert.assertEquals(reservations.size(), 4);
    }

    @Test
    public void reservationsHasProducts(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Reservation single = reservationService.findReservationById(reservation1.getId());
        Assert.assertNotNull(single.getProducts());
        Assert.assertTrue(single.getProducts().size() > 0);

        Reservation reservation2 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Reservation fromList = reservationService.findAllReservations().get(0);
        Assert.assertNotNull(fromList.getProducts());
        Assert.assertTrue(fromList.getProducts().size() > 0);
    }


    @Test
    public void closedReservationsAreRead(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2, MockedData.restaurantId());
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products1, MockedData.restaurantId());
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products2, MockedData.restaurantId());
        Reservation reservation5 = reservationService.createReservationAndAddProducts(products2, MockedData.restaurantId());


        reservationService.changeReservationState(reservation1.getId(), false);
        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation4.getId(), false);

        List<Reservation> closedReservations = reservationService.getAllClosedReservations();
        Assert.assertEquals(closedReservations.size(), 4);

    }


}
