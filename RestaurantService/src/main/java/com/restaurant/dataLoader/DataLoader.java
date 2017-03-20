package com.restaurant.dataLoader;

import com.restaurant.dto.Product;
import com.restaurant.dto.Reservation;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.util.MockedData;
import model.BookingProduct;
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
        Product product25 = productService.createProduct(MockedData.productName());
        Product product26 = productService.createProduct(MockedData.productName());
        Product product27 = productService.createProduct(MockedData.productName());
        Product product28 = productService.createProduct(MockedData.productName());
        Product product29 = productService.createProduct(MockedData.productName());
        Product product30 = productService.createProduct(MockedData.productName());
        Product product31 = productService.createProduct(MockedData.productName());
        Product product32 = productService.createProduct(MockedData.productName());
        Product product33 = productService.createProduct(MockedData.productName());
        Product product34 = productService.createProduct(MockedData.productName());
        Product product35 = productService.createProduct(MockedData.productName());
        Product product36 = productService.createProduct(MockedData.productName());
        Product product37 = productService.createProduct(MockedData.productName());
        Product product38 = productService.createProduct(MockedData.productName());
        Product product39 = productService.createProduct(MockedData.productName());
        Product product40 = productService.createProduct(MockedData.productName());
        Product product41 = productService.createProduct(MockedData.productName());
        Product product42 = productService.createProduct(MockedData.productName());
        Product product43 = productService.createProduct(MockedData.productName());
        Product product44 = productService.createProduct(MockedData.productName());
        Product product45 = productService.createProduct(MockedData.productName());
        Product product46 = productService.createProduct(MockedData.productName());
        Product product47 = productService.createProduct(MockedData.productName());
        Product product48 = productService.createProduct(MockedData.productName());
        Product product49 = productService.createProduct(MockedData.productName());
        Product product50 = productService.createProduct(MockedData.productName());
        Product product51 = productService.createProduct(MockedData.productName());
        Product product52 = productService.createProduct(MockedData.productName());
        Product product53 = productService.createProduct(MockedData.productName());
        Product product54 = productService.createProduct(MockedData.productName());
        Product product55 = productService.createProduct(MockedData.productName());
        Product product56 = productService.createProduct(MockedData.productName());
        Product product57 = productService.createProduct(MockedData.productName());
        Product product58 = productService.createProduct(MockedData.productName());
        Product product59 = productService.createProduct(MockedData.productName());
        Product product60 = productService.createProduct(MockedData.productName());
        Product product61 = productService.createProduct(MockedData.productName());
        Product product62 = productService.createProduct(MockedData.productName());
        Product product63 = productService.createProduct(MockedData.productName());
        Product product64 = productService.createProduct(MockedData.productName());
        Product product65 = productService.createProduct(MockedData.productName());
        Product product66 = productService.createProduct(MockedData.productName());
        Product product67 = productService.createProduct(MockedData.productName());
        Product product68 = productService.createProduct(MockedData.productName());
        Product product69 = productService.createProduct(MockedData.productName());
        Product product70 = productService.createProduct(MockedData.productName());
        Product product71 = productService.createProduct(MockedData.productName());
        Product product72 = productService.createProduct(MockedData.productName());
        Product product73 = productService.createProduct(MockedData.productName());
        Product product74 = productService.createProduct(MockedData.productName());
        Product product75 = productService.createProduct(MockedData.productName());
        Product product76 = productService.createProduct(MockedData.productName());
        Product product77 = productService.createProduct(MockedData.productName());
        Product product78 = productService.createProduct(MockedData.productName());
        Product product79 = productService.createProduct(MockedData.productName());
        Product product80 = productService.createProduct(MockedData.productName());


        List<BookingProduct> products1 = new LinkedList<>();
        List<BookingProduct> products2 = new LinkedList<>();
        List<BookingProduct> products3 = new LinkedList<>();
        List<BookingProduct> products4 = new LinkedList<>();
        products1.add(new BookingProduct(product1.getId(), random.nextInt(15) + 0));
        products1.add(new BookingProduct(product2.getId(), random.nextInt(15) + 1));
        products1.add(new BookingProduct(product3.getId(), random.nextInt(15) + 1));
        products2.add(new BookingProduct(product2.getId(), random.nextInt(15) + 0));
        products2.add(new BookingProduct(product3.getId(), random.nextInt(15) + 1));
        products2.add(new BookingProduct(product4.getId(), random.nextInt(15) + 1));
        products2.add(new BookingProduct(product5.getId(), random.nextInt(15) + 1));
        products3.add(new BookingProduct(product5.getId(), random.nextInt(15) + 0));
        products3.add(new BookingProduct(product6.getId(), random.nextInt(15) + 1));
        products3.add(new BookingProduct(product7.getId(), random.nextInt(15) + 1));
        products4.add(new BookingProduct(product6.getId(), random.nextInt(15) + 0));
        products4.add(new BookingProduct(product7.getId(), random.nextInt(15) + 1));
        products4.add(new BookingProduct(product8.getId(), random.nextInt(15) + 1));
        products4.add(new BookingProduct(product9.getId(), random.nextInt(15) + 1));
        products4.add(new BookingProduct(product10.getId(), random.nextInt(15) + 1));

        List<BookingProduct> products11 = new LinkedList<>();
        List<BookingProduct> products12 = new LinkedList<>();
        List<BookingProduct> products13 = new LinkedList<>();
        List<BookingProduct> products14 = new LinkedList<>();
        products11.add(new BookingProduct(product11.getId(), random.nextInt(15) + 0));
        products11.add(new BookingProduct(product12.getId(), random.nextInt(15) + 1));
        products11.add(new BookingProduct(product13.getId(), random.nextInt(15) + 1));
        products12.add(new BookingProduct(product12.getId(), random.nextInt(15) + 0));
        products12.add(new BookingProduct(product13.getId(), random.nextInt(15) + 1));
        products12.add(new BookingProduct(product14.getId(), random.nextInt(15) + 1));
        products12.add(new BookingProduct(product15.getId(), random.nextInt(15) + 1));
        products13.add(new BookingProduct(product15.getId(), random.nextInt(15) + 0));
        products13.add(new BookingProduct(product16.getId(), random.nextInt(15) + 1));
        products13.add(new BookingProduct(product17.getId(), random.nextInt(15) + 1));
        products14.add(new BookingProduct(product16.getId(), random.nextInt(15) + 0));
        products14.add(new BookingProduct(product17.getId(), random.nextInt(15) + 1));
        products14.add(new BookingProduct(product18.getId(), random.nextInt(15) + 1));
        products14.add(new BookingProduct(product19.getId(), random.nextInt(15) + 1));
        products14.add(new BookingProduct(product20.getId(), random.nextInt(15) + 1));


        List<BookingProduct> products21 = new LinkedList<>();
        List<BookingProduct> products22 = new LinkedList<>();
        List<BookingProduct> products23 = new LinkedList<>();
        List<BookingProduct> products24 = new LinkedList<>();
        products21.add(new BookingProduct(product21.getId(), random.nextInt(15) + 0));
        products21.add(new BookingProduct(product22.getId(), random.nextInt(15) + 1));
        products21.add(new BookingProduct(product23.getId(), random.nextInt(15) + 1));
        products22.add(new BookingProduct(product22.getId(), random.nextInt(15) + 0));
        products22.add(new BookingProduct(product23.getId(), random.nextInt(15) + 1));
        products22.add(new BookingProduct(product24.getId(), random.nextInt(15) + 1));
        products22.add(new BookingProduct(product25.getId(), random.nextInt(15) + 1));
        products23.add(new BookingProduct(product25.getId(), random.nextInt(15) + 0));
        products23.add(new BookingProduct(product26.getId(), random.nextInt(15) + 1));
        products23.add(new BookingProduct(product27.getId(), random.nextInt(15) + 1));
        products24.add(new BookingProduct(product26.getId(), random.nextInt(15) + 0));
        products24.add(new BookingProduct(product27.getId(), random.nextInt(15) + 1));
        products24.add(new BookingProduct(product28.getId(), random.nextInt(15) + 1));
        products24.add(new BookingProduct(product29.getId(), random.nextInt(15) + 1));
        products24.add(new BookingProduct(product30.getId(), random.nextInt(15) + 1));


        List<BookingProduct> products31 = new LinkedList<>();
        List<BookingProduct> products32 = new LinkedList<>();
        List<BookingProduct> products33 = new LinkedList<>();
        List<BookingProduct> products34 = new LinkedList<>();
        products31.add(new BookingProduct(product31.getId(), random.nextInt(15) + 0));
        products31.add(new BookingProduct(product32.getId(), random.nextInt(15) + 1));
        products31.add(new BookingProduct(product33.getId(), random.nextInt(15) + 1));
        products32.add(new BookingProduct(product32.getId(), random.nextInt(15) + 0));
        products32.add(new BookingProduct(product33.getId(), random.nextInt(15) + 1));
        products32.add(new BookingProduct(product34.getId(), random.nextInt(15) + 1));
        products32.add(new BookingProduct(product35.getId(), random.nextInt(15) + 1));
        products33.add(new BookingProduct(product35.getId(), random.nextInt(15) + 0));
        products33.add(new BookingProduct(product36.getId(), random.nextInt(15) + 1));
        products33.add(new BookingProduct(product37.getId(), random.nextInt(15) + 1));
        products34.add(new BookingProduct(product36.getId(), random.nextInt(15) + 0));
        products34.add(new BookingProduct(product37.getId(), random.nextInt(15) + 1));
        products34.add(new BookingProduct(product38.getId(), random.nextInt(15) + 1));
        products34.add(new BookingProduct(product39.getId(), random.nextInt(15) + 1));
        products34.add(new BookingProduct(product40.getId(), random.nextInt(15) + 1));


        List<BookingProduct> products41 = new LinkedList<>();
        List<BookingProduct> products42 = new LinkedList<>();
        List<BookingProduct> products43 = new LinkedList<>();
        List<BookingProduct> products44 = new LinkedList<>();
        products41.add(new BookingProduct(product41.getId(), random.nextInt(15) + 0));
        products41.add(new BookingProduct(product42.getId(), random.nextInt(15) + 1));
        products41.add(new BookingProduct(product43.getId(), random.nextInt(15) + 1));
        products42.add(new BookingProduct(product42.getId(), random.nextInt(15) + 0));
        products42.add(new BookingProduct(product43.getId(), random.nextInt(15) + 1));
        products42.add(new BookingProduct(product44.getId(), random.nextInt(15) + 1));
        products42.add(new BookingProduct(product45.getId(), random.nextInt(15) + 1));
        products43.add(new BookingProduct(product45.getId(), random.nextInt(15) + 0));
        products43.add(new BookingProduct(product46.getId(), random.nextInt(15) + 1));
        products43.add(new BookingProduct(product47.getId(), random.nextInt(15) + 1));
        products44.add(new BookingProduct(product46.getId(), random.nextInt(15) + 0));
        products44.add(new BookingProduct(product47.getId(), random.nextInt(15) + 1));
        products44.add(new BookingProduct(product48.getId(), random.nextInt(15) + 1));
        products44.add(new BookingProduct(product49.getId(), random.nextInt(15) + 1));
        products44.add(new BookingProduct(product50.getId(), random.nextInt(15) + 1));

        List<BookingProduct> products51 = new LinkedList<>();
        List<BookingProduct> products52 = new LinkedList<>();
        List<BookingProduct> products53 = new LinkedList<>();
        List<BookingProduct> products54 = new LinkedList<>();
        products51.add(new BookingProduct(product51.getId(), random.nextInt(15) + 0));
        products51.add(new BookingProduct(product52.getId(), random.nextInt(15) + 1));
        products51.add(new BookingProduct(product53.getId(), random.nextInt(15) + 1));
        products52.add(new BookingProduct(product52.getId(), random.nextInt(15) + 0));
        products52.add(new BookingProduct(product53.getId(), random.nextInt(15) + 1));
        products52.add(new BookingProduct(product54.getId(), random.nextInt(15) + 1));
        products52.add(new BookingProduct(product55.getId(), random.nextInt(15) + 1));
        products53.add(new BookingProduct(product55.getId(), random.nextInt(15) + 0));
        products53.add(new BookingProduct(product56.getId(), random.nextInt(15) + 1));
        products53.add(new BookingProduct(product57.getId(), random.nextInt(15) + 1));
        products54.add(new BookingProduct(product56.getId(), random.nextInt(15) + 0));
        products54.add(new BookingProduct(product57.getId(), random.nextInt(15) + 1));
        products54.add(new BookingProduct(product58.getId(), random.nextInt(15) + 1));
        products54.add(new BookingProduct(product59.getId(), random.nextInt(15) + 1));
        products54.add(new BookingProduct(product60.getId(), random.nextInt(15) + 1));

        List<BookingProduct> products61 = new LinkedList<>();
        List<BookingProduct> products62 = new LinkedList<>();
        List<BookingProduct> products63 = new LinkedList<>();
        List<BookingProduct> products64 = new LinkedList<>();
        products61.add(new BookingProduct(product61.getId(), random.nextInt(15) + 0));
        products61.add(new BookingProduct(product62.getId(), random.nextInt(15) + 1));
        products61.add(new BookingProduct(product63.getId(), random.nextInt(15) + 1));
        products62.add(new BookingProduct(product62.getId(), random.nextInt(15) + 0));
        products62.add(new BookingProduct(product63.getId(), random.nextInt(15) + 1));
        products62.add(new BookingProduct(product64.getId(), random.nextInt(15) + 1));
        products62.add(new BookingProduct(product65.getId(), random.nextInt(15) + 1));
        products63.add(new BookingProduct(product65.getId(), random.nextInt(15) + 0));
        products63.add(new BookingProduct(product66.getId(), random.nextInt(15) + 1));
        products63.add(new BookingProduct(product67.getId(), random.nextInt(15) + 1));
        products64.add(new BookingProduct(product66.getId(), random.nextInt(15) + 0));
        products64.add(new BookingProduct(product67.getId(), random.nextInt(15) + 1));
        products64.add(new BookingProduct(product68.getId(), random.nextInt(15) + 1));
        products64.add(new BookingProduct(product69.getId(), random.nextInt(15) + 1));
        products64.add(new BookingProduct(product70.getId(), random.nextInt(15) + 1));


        List<BookingProduct> products71 = new LinkedList<>();
        List<BookingProduct> products72 = new LinkedList<>();
        List<BookingProduct> products73 = new LinkedList<>();
        List<BookingProduct> products74 = new LinkedList<>();
        products71.add(new BookingProduct(product71.getId(), random.nextInt(15) + 0));
        products71.add(new BookingProduct(product72.getId(), random.nextInt(15) + 1));
        products71.add(new BookingProduct(product73.getId(), random.nextInt(15) + 1));
        products72.add(new BookingProduct(product72.getId(), random.nextInt(15) + 0));
        products72.add(new BookingProduct(product73.getId(), random.nextInt(15) + 1));
        products72.add(new BookingProduct(product74.getId(), random.nextInt(15) + 1));
        products72.add(new BookingProduct(product75.getId(), random.nextInt(15) + 1));
        products73.add(new BookingProduct(product75.getId(), random.nextInt(15) + 0));
        products73.add(new BookingProduct(product76.getId(), random.nextInt(15) + 1));
        products73.add(new BookingProduct(product77.getId(), random.nextInt(15) + 1));
        products74.add(new BookingProduct(product76.getId(), random.nextInt(15) + 0));
        products74.add(new BookingProduct(product77.getId(), random.nextInt(15) + 1));
        products74.add(new BookingProduct(product78.getId(), random.nextInt(15) + 1));
        products74.add(new BookingProduct(product79.getId(), random.nextInt(15) + 1));
        products74.add(new BookingProduct(product80.getId(), random.nextInt(15) + 1));


        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products3);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products4);

        Reservation reservation11 = reservationService.createReservationAndAddProducts(products11);
        Reservation reservation12 = reservationService.createReservationAndAddProducts(products12);
        Reservation reservation13 = reservationService.createReservationAndAddProducts(products13);
        Reservation reservation14 = reservationService.createReservationAndAddProducts(products14);

        Reservation reservation21 = reservationService.createReservationAndAddProducts(products21);
        Reservation reservation22 = reservationService.createReservationAndAddProducts(products22);
        Reservation reservation23 = reservationService.createReservationAndAddProducts(products23);
        Reservation reservation24 = reservationService.createReservationAndAddProducts(products24);

        Reservation reservation31 = reservationService.createReservationAndAddProducts(products31);
        Reservation reservation32 = reservationService.createReservationAndAddProducts(products32);
        Reservation reservation33 = reservationService.createReservationAndAddProducts(products33);
        Reservation reservation34 = reservationService.createReservationAndAddProducts(products34);

        Reservation reservation41 = reservationService.createReservationAndAddProducts(products41);
        Reservation reservation42 = reservationService.createReservationAndAddProducts(products42);
        Reservation reservation43 = reservationService.createReservationAndAddProducts(products43);
        Reservation reservation44 = reservationService.createReservationAndAddProducts(products44);

        Reservation reservation51 = reservationService.createReservationAndAddProducts(products51);
        Reservation reservation52 = reservationService.createReservationAndAddProducts(products52);
        Reservation reservation53 = reservationService.createReservationAndAddProducts(products53);
        Reservation reservation54 = reservationService.createReservationAndAddProducts(products54);

        Reservation reservation61 = reservationService.createReservationAndAddProducts(products61);
        Reservation reservation62 = reservationService.createReservationAndAddProducts(products62);
        Reservation reservation63 = reservationService.createReservationAndAddProducts(products63);
        Reservation reservation64 = reservationService.createReservationAndAddProducts(products64);

        Reservation reservation71 = reservationService.createReservationAndAddProducts(products71);
        Reservation reservation72 = reservationService.createReservationAndAddProducts(products72);
        Reservation reservation73 = reservationService.createReservationAndAddProducts(products73);
        Reservation reservation74 = reservationService.createReservationAndAddProducts(products74);

        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation11.getId(), false);
        reservationService.changeReservationState(reservation21.getId(), false);
        reservationService.changeReservationState(reservation24.getId(), false);
        reservationService.changeReservationState(reservation32.getId(), false);
        reservationService.changeReservationState(reservation43.getId(), false);
        reservationService.changeReservationState(reservation52.getId(), false);
        reservationService.changeReservationState(reservation61.getId(), false);
        reservationService.changeReservationState(reservation74.getId(), false);
    }
}
