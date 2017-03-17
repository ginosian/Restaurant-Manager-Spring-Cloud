import com.booking.Application;
import com.booking.dto.Booking;
import com.booking.service.BookingService;
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
    BookingService bookingService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Booking booking1;
    private Booking booking2;
    private Booking booking3;
    private Booking booking4;
    private Booking booking5;

    @Before
    public void initRawEntities(){
        booking1 = bookingService.createBooking(MockedData.userId(), MockedData.restaurantId(), MockedData.reservationId());
        booking2 = bookingService.createBooking(MockedData.userId(), MockedData.restaurantId(), MockedData.reservationId());
        booking3 = bookingService.createBooking(MockedData.userId(), MockedData.restaurantId(), MockedData.reservationId());
        booking4 = bookingService.createBooking(MockedData.userId(), MockedData.restaurantId(), MockedData.reservationId());
        booking5 = bookingService.createBooking(MockedData.userId(), MockedData.restaurantId(), MockedData.reservationId());

    }

    @Test
    public void testServices() {
        Assert.assertNotNull(bookingService);
    }


    @Test
    public void testBookingService() {
        // Booking is created
        Assert.assertNotNull(bookingService.findBookingById(booking1.getId()));
        Assert.assertNull(bookingService.createBooking(booking1.getUserId(), booking1.getRestaurantId(), booking1.getReservationId()));

        // Booking is deleted
        Assert.assertTrue(bookingService.deleteBooking(booking1.getId()));
        Assert.assertNull(bookingService.findBookingById(booking1.getId()));

        // Booking is deleted double times
        thrown.expect(Exception.class);
        bookingService.deleteBooking(booking1.getId());
    }

}
