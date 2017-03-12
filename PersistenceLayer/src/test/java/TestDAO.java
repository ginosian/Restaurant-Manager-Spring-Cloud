import com.restaurant.Application;
import com.restaurant.dto.*;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.UserService;
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

import java.util.*;

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
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Role role1;
    private Role role2;

    private User user1;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    private List<ChooserProduct> products1;
    private List<ChooserProduct> products2;

    @Before
    public void initRawEntities(){
        role1 = userService.createRole(MockedData.roleName());
        role2 = userService.createRole(MockedData.roleName());

        user1 = userService.createUser(MockedData.userName(), MockedData.password(), role1, role2);

        product1 = productService.createProduct(MockedData.productName());
        product2 = productService.createProduct(MockedData.productName());
        product3 = productService.createProduct(MockedData.productName());
        product4 = productService.createProduct(MockedData.productName());
        product5 = productService.createProduct(MockedData.productName());

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
        Assert.assertNotNull(userService);
        Assert.assertNotNull(productService);
        Assert.assertNotNull(reservationService);
    }

    @Test
    public void testRole() {
        // Roles are created
        Assert.assertNotNull(role1.getId());
    }

    @Test
    public void testUserService() {
        // Users are created
        Assert.assertNotNull(user1.getId());
        Assert.assertNotNull(userService.findUser(user1.getId()));
        Assert.assertNotNull(userService.findUser(user1.getUsername()));

        // Overriding effect of hashcode and equals are applied
        Assert.assertEquals(user1, userService.findUser(user1.getId()));

        // A null is returned if duplicate user is attempt to record
        Assert.assertNull(userService.createUser(user1.getUsername(), user1.getPassword(), role1, role2));

        // User deleted
        Assert.assertTrue(userService.deleteUser(user1.getId()));
        Assert.assertNull(userService.findUser(user1.getId()));
    }

    @Test
    public void testProductService() {
        // Product is created
        Assert.assertNotNull(productService.findProduct(product1.getId()));
        Assert.assertNull(productService.createProduct(product1.getProductName()));

        // Product is read
        Assert.assertNotNull(productService.findProduct(product1.getProductName()));
        Assert.assertEquals(productService.findProduct(product1.getProductName()), productService.findProduct(product1.getId()));

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
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Assert.assertNotNull(reservationService.findReservationById(reservation1.getId()));

        //An association user with reservation is set
        List<Reservation> reservations = reservationService.findAllReservationsByUserId(user1.getId());
        Assert.assertNotNull(reservations);
        Assert.assertEquals(reservations.size(), 1);
        Assert.assertEquals((long) reservations.get(0).getId(), (long) reservation1.getId());


    }
    @Test
    public void addProductInReservation(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
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
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
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
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
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
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products2);
        Assert.assertEquals(reservation1.getProducts().size(), 1);

        ProductInReservation productInReservation = reservation1.getProducts().iterator().next();
        Assert.assertNotNull(productInReservation.getId());

        List<Reservation> reservationFromUser = reservationService.findAllReservationsByUserId(user1.getId());
        Assert.assertEquals(reservation1, reservationFromUser.get(0));

        reservationService.changeReservationState(reservation1.getId(), false);
        reservationService.deleteReservation(reservation1.getId());

        Assert.assertNull(reservationService.findReservationById(reservation1.getId()));
        Assert.assertEquals(reservationService.findAllReservationsByUserId(user1.getId()).size(), 0);
    }

    @Test
    public void deleteUser(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(user1.getId(), products2);
        List<Reservation> reservationFromUser = reservationService.findAllReservationsByUserId(user1.getId());
        List<ProductInReservation> productsFromReservations = new LinkedList<>();
        for(Reservation reservation : reservationFromUser){
            productsFromReservations.addAll(reservation.getProducts());
        }

        userService.deleteUser(user1.getId());

        Assert.assertNull(reservationService.findAllReservationsByUserId(user1.getId()));
        Assert.assertNull(reservationService.findReservationById(reservation1.getId()));
        Assert.assertNull(reservationService.findReservationById(reservation2.getId()));

        for(ProductInReservation product : productsFromReservations){
            Assert.assertTrue(reservationService.productInReservetionIsDeleted(product.getId()));
        }
    }

    @Test
    public void readReservationLazy(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(user1.getId(), products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(user1.getId(), products2);

        List<Reservation> reservations = reservationService.findAllReservations();
        Assert.assertEquals(reservations.size(), 4);


    }

    @Test
    public void readUsersLazy(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(user1.getId(), products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(user1.getId(), products2);

        Set<Reservation> reservations = userService.getAllUsers().get(0).getReservations();
        Reservation reservation = (Reservation) reservations.iterator().next().getProducts().iterator().next().getReservation();
        Assert.assertNull(reservation);
    }


    @Test
    public void reservationsHasProducts(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation single = reservationService.findReservationById(reservation1.getId());
        Assert.assertNotNull(single.getProducts());
        Assert.assertTrue(single.getProducts().size() > 0);

        Reservation reservation2 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation fromList = reservationService.findAllReservations().get(0);
        Assert.assertNotNull(fromList.getProducts());
        Assert.assertTrue(fromList.getProducts().size() > 0);
    }


    @Test
    public void closedReservationsAreRead(){
        Reservation reservation1 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(user1.getId(), products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(user1.getId(), products1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(user1.getId(), products2);
        Reservation reservation5 = reservationService.createReservationAndAddProducts(user1.getId(), products2);


        reservationService.changeReservationState(reservation1.getId(), false);
        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation4.getId(), false);

        List<Reservation> closedReservations = reservationService.getAllClosedReservations();
        Assert.assertEquals(closedReservations.size(), 4);

    }


}
