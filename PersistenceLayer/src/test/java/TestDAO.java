import com.restaurant.Application;
import com.restaurant.dto.Product;
import com.restaurant.dto.Role;
import com.restaurant.dto.User;
import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.UserService;
import org.junit.Assert;
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
@TestPropertySource(locations="classpath:test.properties")
public class TestDAO {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testServices(){
        Assert.assertNotNull(userService);
        Assert.assertNotNull(productService);
        Assert.assertNotNull(reservationService);
    }

    @Test
    public void createRole(){
        Role role1 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role1.getId());
        Role role2 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role2.getId());
        Role role3 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role3.getId());
    }

    @Test
    public void createUser(){
        Role role1 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role1.getId());
        Role role2 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role2.getId());
        Role role3 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role3.getId());

        User user1 = userService.createUser(MockedData.userName(), MockedData.password(), role1, role2);
        Assert.assertNotNull(user1.getId());
        User user2 = userService.createUser(MockedData.userName(), MockedData.password(), role2, role3);
        Assert.assertNotNull(user2.getId());
        User user3 = userService.createUser(MockedData.userName(), MockedData.password(), role3, role1);
        Assert.assertNotNull(user3.getId());
    }

    @Test
    public void testUserService(){
        // Create roles
        Role role1 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role1.getId());
        Role role2 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role2.getId());
        Role role3 = userService.createRole(MockedData.roleName());
        Assert.assertNotNull(role3.getId());

        // Create user
        User user1 = userService.createUser(MockedData.userName(), MockedData.password(), role1, role2);
        Assert.assertNotNull(user1.getId());
        Assert.assertNotNull(userService.findUser(user1.getId()));
        Assert.assertNotNull(userService.findUser(user1.getUsername()));
        User user2 = userService.createUser(MockedData.userName(), MockedData.password(), role2, role3);
        Assert.assertNotNull(user2.getId());
        User user3 = userService.createUser(MockedData.userName(), MockedData.password(), role3, role1);
        Assert.assertNotNull(user3.getId());

        // Override hashcode and equals applied effect
        Assert.assertEquals(user1, userService.findUser(user1.getId()));

        // Return null if duplicate user is attempt to record
        Assert.assertNull(userService.createUser(user1.getUsername(), user1.getPassword(), role1, role2));

        // Delete user
        Assert.assertTrue(userService.deleteUser(user2.getId()));
        Assert.assertNull(userService.findUser(user2.getId()));
    }

    @Test
    public void testProductService(){
        // Product creation
        Product product1 = productService.createProduct(MockedData.productName());
        Assert.assertNotNull(productService.findProduct(product1.getId()));
        Assert.assertNull(productService.createProduct(product1.getProductName()));

        // Product reading
        Assert.assertNotNull(productService.findProduct(product1.getProductName()));
        Assert.assertEquals(productService.findProduct(product1.getProductName()), productService.findProduct(product1.getId()));

        // Product updating
        Product product2 = productService.updateProductName(product1.getId(), MockedData.productName());
        Assert.assertEquals(product1.getId(), product2.getId());
        Assert.assertEquals(product1, product2);
        Assert.assertNotEquals(product1.getProductName(), product2.getProductName());

        // Product deleting
        Assert.assertTrue(productService.deleteProduct(product1.getId()));
        Assert.assertNull(productService.findProduct(product1.getId()));


        // Double deleting
        thrown.expect(Exception.class);
        productService.deleteProduct(product1.getId());

    }

}
