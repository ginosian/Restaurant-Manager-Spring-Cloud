package com.restaurant.dataLoader;

import com.restaurant.dto.Product;
import com.restaurant.dto.Reservation;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.helperModels.ChooserProduct;
import com.restaurant.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Martha on 3/18/2017.
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private ReservationService reservationService;

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Random random = new Random();

        Product product1 = productService.createProduct(MockedData.productName());
        Product product2 = productService.createProduct(MockedData.productName());
        Product product3 = productService.createProduct(MockedData.productName());
        Product product4 = productService.createProduct(MockedData.productName());
        Product product5 = productService.createProduct(MockedData.productName());
        Product product6 = productService.createProduct(MockedData.productName());
        Product product7 = productService.createProduct(MockedData.productName());
        Product product8 = productService.createProduct(MockedData.productName());
        Product product9 = productService.createProduct(MockedData.productName());
        Product product10 = productService.createProduct(MockedData.productName());
        Product product11 = productService.createProduct(MockedData.productName());
        Product product12 = productService.createProduct(MockedData.productName());
        Product product13 = productService.createProduct(MockedData.productName());
        Product product14 = productService.createProduct(MockedData.productName());
        Product product15 = productService.createProduct(MockedData.productName());
        Product product16 = productService.createProduct(MockedData.productName());
        Product product17 = productService.createProduct(MockedData.productName());
        Product product18 = productService.createProduct(MockedData.productName());
        Product product19 = productService.createProduct(MockedData.productName());
        Product product20 = productService.createProduct(MockedData.productName());
        Product product21 = productService.createProduct(MockedData.productName());
        Product product22 = productService.createProduct(MockedData.productName());
        Product product23 = productService.createProduct(MockedData.productName());
        Product product24 = productService.createProduct(MockedData.productName());

        List<ChooserProduct> products1 = new LinkedList<>();
        products1.add(new ChooserProduct(product1.getId(), random.nextInt(15) + 0));
        products1.add(new ChooserProduct(product2.getId(), random.nextInt(15) + 1));
        products1.add(new ChooserProduct(product3.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products2 = new LinkedList<>();
        products2.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 0));
        products2.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products2.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products2.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products3 = new LinkedList<>();
        products3.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 0));
        products3.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products3.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products4 = new LinkedList<>();
        products4.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 0));
        products4.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products4.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products4.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products4.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products4.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products5 = new LinkedList<>();
        products5.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products5.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products6 = new LinkedList<>();
        products6.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products6.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products6.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products7 = new LinkedList<>();
        products7.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products7.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products7.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        List<ChooserProduct> products8 = new LinkedList<>();
        products8.add(new ChooserProduct(product4.getId(), random.nextInt(15) + 1));
        products8.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));
        products8.add(new ChooserProduct(product5.getId(), random.nextInt(15) + 1));

        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products3);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products4);
        Reservation reservation5 = reservationService.createReservationAndAddProducts(products5);
        Reservation reservation6 = reservationService.createReservationAndAddProducts(products6);
        Reservation reservation7 = reservationService.createReservationAndAddProducts(products7);
        Reservation reservation8 = reservationService.createReservationAndAddProducts(products8);
        Reservation reservation9 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation10 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation11 = reservationService.createReservationAndAddProducts(products3);
        Reservation reservation12 = reservationService.createReservationAndAddProducts(products4);
        Reservation reservation13 = reservationService.createReservationAndAddProducts(products5);
        Reservation reservation14 = reservationService.createReservationAndAddProducts(products6);
        Reservation reservation15 = reservationService.createReservationAndAddProducts(products7);
        Reservation reservation16 = reservationService.createReservationAndAddProducts(products8);
        Reservation reservation17 = reservationService.createReservationAndAddProducts(products1);

        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation5.getId(), false);
        reservationService.changeReservationState(reservation8.getId(), false);
        reservationService.changeReservationState(reservation5.getId(), false);
        reservationService.changeReservationState(reservation16.getId(), false);
    }
}
