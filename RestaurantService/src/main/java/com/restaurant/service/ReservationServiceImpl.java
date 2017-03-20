package com.restaurant.service;

import com.restaurant.dao.ProductDAO;
import com.restaurant.dao.ReservationDAO;
import com.restaurant.dto.Product;
import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.util.BusKeyGen;
import com.restaurant.util.Validate;
import model.BookingProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
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
    ProductDAO productDAO;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public Reservation createReservationAndAddProducts(List<BookingProduct> products) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(products) || products.size() == 0) return null;
        for (BookingProduct product : products) {
            int productId = product.getProductId();
            if (!productDAO.containsProductById(productId)) return null;
        }
        //Form entity
        Set<ProductInReservation> productInReservations = new HashSet<>();
        for (BookingProduct product : products) {
            if (product.getAmount() <= 0) continue;
            Product chooserProduct = productDAO.readProduct(product.getProductId());
            productInReservations.add(new ProductInReservation(chooserProduct, product.getAmount(), BusKeyGen.nextKey()));
        }
        //Persist
        Reservation reservation = new Reservation(BusKeyGen.nextKey(), true);
        reservation.setProducts(productInReservations);
        return reservationDAO.writeReservation(reservation);
    }

    @Override
    public Reservation addProductInReservation(int reservationId, int productId, int amount) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(productId, amount, reservationId)) return null;
        Reservation reservation = reservationDAO.readReservation(reservationId);
        if (reservation == null || !reservation.getIsOpen()) return null;
        if (!productDAO.containsProductById(productId)) return null;
        //Form entity
        Product product = productDAO.readProduct(productId);
        reservation.setProductInReservation(new ProductInReservation(product, reservation, amount, BusKeyGen.nextKey()));
        // Persist
        return reservationDAO.updateReservation(reservation);
    }

    @Override
    public Reservation changeProductAmountInReservation(int reservationId, int productInReservationId, int amount) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(productInReservationId, amount, reservationId)) return null;
        Reservation reservation = reservationDAO.readReservation(reservationId);
        if (reservation == null || !reservation.getIsOpen()) return null;
        ProductInReservation productInReservation = reservationDAO.readProductInReservation(productInReservationId);
        if (!Validate.valid(productInReservation.getId())) return null;
        // Persist
        productInReservation.setAmount(amount);
        reservation.setProductInReservation(productInReservation);
        return reservationDAO.updateReservation(reservation);
    }

    @Override
    public boolean deleteProductFromReservation(int reservationId, int productInReservationId) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(reservationId, productInReservationId)) return false;
        Reservation reservation = reservationDAO.readReservation(reservationId);
        if (reservation == null || !reservation.getIsOpen()) return false;
        ProductInReservation productInReservation = reservationDAO.readProductInReservation(productInReservationId);
        if (productInReservation == null) return true;
        // Persist
        Iterator iterator = reservation.getProducts().iterator();
        while (iterator.hasNext()) {
            ProductInReservation productToBeDeleted = (ProductInReservation) iterator.next();
            if (productToBeDeleted.getId() == productInReservationId)
                iterator.remove();
        }
        return reservationDAO.deleteProductInReservation(productInReservationId);
    }

    @Override
    public Reservation changeReservationState(int reservationId, boolean isActive) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(reservationId)) return null;
        Reservation reservation = reservationDAO.readReservation(reservationId);
        if (reservation == null) return null;
        // Form entity
        reservation.setIsOpen(isActive);
        // Persist
        return reservationDAO.updateReservation(reservation);
    }

    @Override
    public Reservation findReservationById(int reservationId) {
        //Validate  (later to be separated in validations service)
        if (!Validate.valid(reservationId)) return null;
        // Persist
        return reservationDAO.readReservation(reservationId);
    }

    @Override
    public List<Reservation> findAllReservations() {
        List<Reservation> reservations = reservationDAO.getAllReservations();
        return reservations;
    }


    @Override
    public boolean deleteReservation(int reservationId) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(reservationId)) return false;
        Reservation reservation = reservationDAO.readReservation(reservationId);
        if (reservation == null || reservation.getIsOpen()) return false;
        // Persist
        return reservationDAO.deleteReservation(reservationId);
    }

    @Override
    public boolean productInReservetionIsDeleted(int productInReservationId) {
        //Validate  (later to be separated in validations service)
        if (!Validate.valid(productInReservationId)) return true;
        return reservationDAO.readProductInReservation(productInReservationId) == null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        //Validate  (later to be separated in validations service)
        if (!Validate.valid(reservation)) return null;
        if (!Validate.valid(reservation.getId())) return null;
        if (reservationDAO.readReservation(reservation.getId()) == null) return null;
        // Persist
        return reservationDAO.updateReservation(reservation);
    }

    @Override
    public List<Reservation> getAllClosedReservations() {
        List<Reservation> reservations = reservationDAO.readAllClosedReservations();
        return reservations;
    }

    @Override
    public List<Reservation> findAllReservations(List<Integer> ids) {
        //Validations (later to be separated in validations service)
        if (!Validate.valid(ids)) return null;
        // Persist
        return reservationDAO.getAllReservations(ids);
    }
}