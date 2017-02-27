package com.restaurant.service;

import com.restaurant.dao.ReservationDAO;
import com.restaurant.dto.ProductInReservation;
import com.restaurant.dto.Reservation;
import com.restaurant.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDAO reservationDAO;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public Reservation writeOrUpdateReservation(Reservation reservation) {
        lock.lock();
        Reservation persistedReservation = reservationDAO.writeOrUpdateReservation(reservation);
        User reservingUser = userService.readUser(reservation.getUser().getId());
        reservingUser.setReservations(persistedReservation);
        userService.writeOrUpdateUser(reservingUser);
        lock.unlock();
        return persistedReservation;
    }

    @Override
    public Reservation readReservation(int reservationId) {
        return reservationDAO.readReservation(reservationId);
    }

    @Override
    public Reservation readReservation(String number) {
        return reservationDAO.readReservation(number);
    }

    @Override //TODO Later add functionality to load only id-s.
    public boolean deleteReservation(int reservationId) {
        lock.lock();
        List<ProductInReservation> products = productService.getAllProducts(reservationId);
        for(ProductInReservation product : products){
            productService.deleteProductInReservation(product.getId());
        }
        boolean deleted = reservationDAO.deleteReservation(reservationId);
        lock.unlock();
        return deleted;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }

    @Override
    public List<Reservation> getAllReservationsByUser(int userId) {
        return reservationDAO.getAllReservationsByUser(userId);
    }

    @Override
    public Reservation changeReservationState(int reservationId, boolean isActive) {
        return reservationDAO.changeReservationState(reservationId, isActive);
    }
}
