package com.restaurant.controller;

import com.restaurant.dto.Product;
import com.restaurant.dto.Reservation;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.helperModels.ChooserProduct;
import com.restaurant.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Martha on 3/5/2017.
 */
@RestController
public class ProductController {
    private static boolean dataIsCreated = false;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/product")
    public void addProduct(String productName){
        productService.createProduct(productName);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @GetMapping(path = "/product/{id}", produces = "application/json")
    public Product getProduct(@PathVariable("id") int id){
        return productService.findProduct(id);
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/product/update")  // A POST mapping instead of PUT in due to my tomcat with current configs doesn't support PUT
    public void updateProduct(Product product){
        productService.updateProductName(product.getId(), product.getProductName());
    }

    @PreAuthorize("hasAnyAuthority('RESTAURANT')")
    @PostMapping(path = "/product/delete/{id}")  // A POST mapping instead of DELETE in due to my tomcat with current configs doesn't support DELETE
    public void deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'RESTAURANT')")
    @GetMapping(path = "/products", produces = "application/json")
    public List<Product> getProducts(){
//        createProducts();
        List<Product> products = productService.findAllProducts();
        return products;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'RESTAURANT')")
    @PostMapping(path = "/products", produces = "application/json")
    public List<Product> getProductsByIds(List<Integer> ids){
        List<Product> products = productService.findAllProducts(ids);
        return products;
    }

    public void createProducts(){
        if(dataIsCreated) return;

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

        List<ChooserProduct> products1 = new LinkedList<>();
        products1.add(new ChooserProduct(product1.getId(), 2));
        products1.add(new ChooserProduct(product2.getId(), 8));
        products1.add(new ChooserProduct(product3.getId(), 5));
        List<ChooserProduct> products2 = new LinkedList<>();
        products2.add(new ChooserProduct(product4.getId(), 20));
        products2.add(new ChooserProduct(product5.getId(), 0));

        Reservation reservation1 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation2 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation3 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation4 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation5 = reservationService.createReservationAndAddProducts(products1);
        Reservation reservation6 = reservationService.createReservationAndAddProducts(products2);
        Reservation reservation7 = reservationService.createReservationAndAddProducts(products1);

        reservationService.changeReservationState(reservation2.getId(), false);
        reservationService.changeReservationState(reservation3.getId(), false);
        reservationService.changeReservationState(reservation4.getId(), false);
        reservationService.changeReservationState(reservation5.getId(), false);
        reservationService.changeReservationState(reservation6.getId(), false);

        dataIsCreated = true;
    }

}
