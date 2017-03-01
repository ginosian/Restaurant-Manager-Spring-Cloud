package com.restaurant.service;

import com.restaurant.dao.ReservationDAO;
import com.restaurant.dto.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static org.terracotta.modules.ehcache.ToolkitInstanceFactoryImpl.LOGGER;

/**
 * Created by Martha on 2/25/2017.
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDAO reservationDAO;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public Reservation createReservation(int userId) {
        long startNanos = System.nanoTime();
        LOGGER.info("CREATE RESERVATION start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("CREATE RESERVATION end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Reservation addProductInReservation(int productId, int amount) {
        long startNanos = System.nanoTime();
        LOGGER.info("ADD PRODUCT IN RESERVATION start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("ADD PRODUCT IN RESERVATION end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Reservation changeProductAmountInReservation(int reservationId, int productId, int amount) {
        long startNanos = System.nanoTime();
        LOGGER.info("CHANGE PRODUCT AMOUNT start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("CHANGE PRODUCT AMOUNT end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Reservation deleteProductFromReservation(int reservationId, int productId) {
        long startNanos = System.nanoTime();
        LOGGER.info("DELETE PRODUCT FROM RESERVATION start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("DELETE PRODUCT FROM RESERVATION end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Reservation changeReservationState(int reservationId, boolean isActive) {
        long startNanos = System.nanoTime();
        LOGGER.info("CHANGE RESERVATION STATE start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("CHANGE RESERVATION STATE end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public Reservation findReservationById(int reservationId) {
        long startNanos = System.nanoTime();
        LOGGER.info("FIND RESERVATION BY ID start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("FIND RESERVATION BY ID end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public List<Reservation> findAllReservations() {
        long startNanos = System.nanoTime();
        LOGGER.info("FIND ALL RESERVATIONS start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("FIND ALL RESERVATIONS end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public List<Reservation> findAllReservationsByUserId(int userId) {
        long startNanos = System.nanoTime();
        LOGGER.info("FIND ALL RESERVATIONS BY USER start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("FIND ALL RESERVATIONS BY USER end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return null;
    }

    @Override
    public boolean deleteReservation(int reservationId) {
        long startNanos = System.nanoTime();
        LOGGER.info("DELETE RESERVATION start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("DELETE RESERVATION end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return false;
    }

    @Override
    public boolean deleteAllReservationsByUser(int userId) {
        long startNanos = System.nanoTime();
        LOGGER.info("DELETE RESERVATION BY USER start / Current thread " + Thread.currentThread().getName() + "*******************************************");

        LOGGER.info("DELETE RESERVATION BY USER end " + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos)) + "/ Current thread " + Thread.currentThread().getName() + "***********************************************************");
        return false;
    }
}
