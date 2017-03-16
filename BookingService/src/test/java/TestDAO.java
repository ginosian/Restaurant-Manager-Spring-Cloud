import com.restaurant.Application;
import com.restaurant.dto.Booking;
import com.restaurant.service.BookingService;
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
        booking1 = bookingService.createRestaurant(MockedData.restaurantName());
        booking2 = bookingService.createRestaurant(MockedData.restaurantName());
        booking3 = bookingService.createRestaurant(MockedData.restaurantName());
        booking4 = bookingService.createRestaurant(MockedData.restaurantName());
        booking5 = bookingService.createRestaurant(MockedData.restaurantName());

    }

    @Test
    public void testServices() {
        Assert.assertNotNull(bookingService);
    }


    @Test
    public void testRestaurantService() {
        // Booking is created
        Assert.assertNotNull(bookingService.findRestaurant(booking1.getId()));
        Assert.assertNull(bookingService.createRestaurant(booking1.getRestaurantName()));

        // Booking is read
        Assert.assertNotNull(bookingService.findRestaurant(booking1.getRestaurantName()));
        Assert.assertEquals(bookingService.findRestaurant(booking1.getRestaurantName()), bookingService.findRestaurant(booking1.getId()));

        // Booking is updated
        Booking booking2 = bookingService.updateRestaurantName(booking1.getId(), MockedData.restaurantName());
        Assert.assertEquals(booking1.getId(), booking2.getId());
        Assert.assertEquals(booking1, booking2);
        Assert.assertNotEquals(booking1.getRestaurantName(), booking2.getRestaurantName());

        // Booking is deleted
        Assert.assertTrue(bookingService.deleteRestaurant(booking1.getId()));
        Assert.assertNull(bookingService.findRestaurant(booking1.getId()));


        // Booking is deleted double times
        thrown.expect(Exception.class);
        bookingService.deleteRestaurant(booking1.getId());
    }

}
