package com.booking.dataLoader;

import com.booking.service.BookingService;
import com.booking.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Martha on 3/18/2017.
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        bookingService.createBooking(MockedData.userId(), 1, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 1, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 1, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 1, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 2, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 2, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 2, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 2, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 3, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 3, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 3, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 3, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 4, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 4, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 4, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 4, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 5, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 5, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 5, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 5, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 6, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 6, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 6, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 6, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 7, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 7, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 7, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 7, MockedData.reservationId());

        bookingService.createBooking(MockedData.userId(), 8, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 8, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 8, MockedData.reservationId());
        bookingService.createBooking(MockedData.userId(), 8, MockedData.reservationId());

    }
}
