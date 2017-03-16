import com.restaurant.Application;
import com.restaurant.dto.Restaurant;
import com.restaurant.service.RestaurantService;
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
    RestaurantService restaurantService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Restaurant restaurant1;
    private Restaurant restaurant2;
    private Restaurant restaurant3;
    private Restaurant restaurant4;
    private Restaurant restaurant5;

    @Before
    public void initRawEntities(){
        restaurant1 = restaurantService.createRestaurant(MockedData.restaurantName());
        restaurant2 = restaurantService.createRestaurant(MockedData.restaurantName());
        restaurant3 = restaurantService.createRestaurant(MockedData.restaurantName());
        restaurant4 = restaurantService.createRestaurant(MockedData.restaurantName());
        restaurant5 = restaurantService.createRestaurant(MockedData.restaurantName());

    }

    @Test
    public void testServices() {
        Assert.assertNotNull(restaurantService);
    }


    @Test
    public void testRestaurantService() {
        // Restaurant is created
        Assert.assertNotNull(restaurantService.findRestaurant(restaurant1.getId()));
        Assert.assertNull(restaurantService.createRestaurant(restaurant1.getRestaurantName()));

        // Restaurant is read
        Assert.assertNotNull(restaurantService.findRestaurant(restaurant1.getRestaurantName()));
        Assert.assertEquals(restaurantService.findRestaurant(restaurant1.getRestaurantName()), restaurantService.findRestaurant(restaurant1.getId()));

        // Restaurant is updated
        Restaurant restaurant2 = restaurantService.updateRestaurantName(restaurant1.getId(), MockedData.restaurantName());
        Assert.assertEquals(restaurant1.getId(), restaurant2.getId());
        Assert.assertEquals(restaurant1, restaurant2);
        Assert.assertNotEquals(restaurant1.getRestaurantName(), restaurant2.getRestaurantName());

        // Restaurant is deleted
        Assert.assertTrue(restaurantService.deleteRestaurant(restaurant1.getId()));
        Assert.assertNull(restaurantService.findRestaurant(restaurant1.getId()));


        // Restaurant is deleted double times
        thrown.expect(Exception.class);
        restaurantService.deleteRestaurant(restaurant1.getId());
    }

}
