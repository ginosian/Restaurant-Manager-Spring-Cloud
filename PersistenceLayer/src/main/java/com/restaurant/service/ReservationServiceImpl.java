package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dao.ReservationDAO;
import com.restaurant.dao.UserDAO;
import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.dto.User;
import com.restaurant.service.helperModels.ChooserProduct;
import com.restaurant.util.BusKeyGen;
import com.restaurant.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDAO reservationDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    ProductDAO productDAO;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public Reservation createReservationAndAddProducts(int userId, List<ChooserProduct> products) {
        //Validations
        if(!Validate.valid(userId))return null;
        if(!Validate.valid(products) || products.size() == 0) return null;
        for(ChooserProduct product : products){
            int productId = product.getProductId();
            if(!productDAO.containsProductById(productId))return null;
        }
        //Form entity
        Set<ProductInReservation> productInReservations = new HashSet<>();
        for(ChooserProduct product : products) {
            if (product.getAmount() <= 0) continue;
            Product chooserProduct = productDAO.readProduct(product.getProductId());
            productInReservations.add(new ProductInReservation(chooserProduct, product.getAmount(), BusKeyGen.nextKey()));
        }
        User user = userDAO.readUser(userId);
        //Persist
        Reservation reservation = reservationDAO.writeReservation(new Reservation(BusKeyGen.nextKey(), user, true));
       return reservationDAO.writeReservation(reservation);
    }

    @Override
    public Reservation addProductInReservation(int productId, int amount) {

        return null;
    }

    @Override
    public Reservation changeProductAmountInReservation(int reservationId, int productId, int amount) {

        return null;
    }

    @Override
    public Reservation deleteProductFromReservation(int reservationId, int productId) {

        return null;
    }

    @Override
    public Reservation changeReservationState(int reservationId, boolean isActive) {

        return null;
    }

    @Override
    public Reservation findReservationById(int reservationId) {

        return null;
    }

    @Override
    public List<Reservation> findAllReservations() {

        return null;
    }

    @Override
    public List<Reservation> findAllReservationsByUserId(int userId) {

        return null;
    }

    @Override
    public boolean deleteReservation(int reservationId) {

        return false;
    }

    @Override
    public boolean deleteAllReservationsByUser(int userId) {

        return false;
    }
}
