package model;

import java.util.List;

/**
 * Created by Martha on 3/19/2017.
 */
public class Reservations {

    private List<BookingProduct> reservationsList;

    public Reservations() {
    }

    public Reservations(List<BookingProduct> reservationsList) {
        this.reservationsList = reservationsList;
    }

    public List<BookingProduct> getReservationsList() {
        return reservationsList;
    }

    public void setReservationsList(List<BookingProduct> reservationsList) {
        this.reservationsList = reservationsList;
    }
}
