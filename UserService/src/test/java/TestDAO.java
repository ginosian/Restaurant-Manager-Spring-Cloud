import com.user.Application;
import com.user.dto.Role;
import com.user.dto.User;
import com.user.service.UserService;
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
    UserService userService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Role role1;
    private Role role2;

    private User user1;

    @Before
    public void initRawEntities(){
        role1 = userService.createRole(MockedData.roleName());
        role2 = userService.createRole(MockedData.roleName());

        user1 = userService.createUser(MockedData.userName(), MockedData.password(), role1.getRole(), role2.getRole());
    }

    @Test
    public void testServices() {
        Assert.assertNotNull(userService);
    }

    @Test
    public void testRole() {
        // Roles are created
        Assert.assertNotNull(role1.getId());
    }

    @Test
    public void testUserService() {
        // Users are created
        Assert.assertNotNull(user1.getId());
        Assert.assertNotNull(userService.findUser(user1.getId()));
        Assert.assertNotNull(userService.findUser(user1.getUsername()));

        // Overriding effect of hashcode and equals are applied
        Assert.assertEquals(user1, userService.findUser(user1.getId()));

        // A null is returned if duplicate user is attempt to record
        Assert.assertNull(userService.createUser(user1.getUsername(), user1.getPassword(), role1.getRole(), role2.getRole()));

        // User deleted
        Assert.assertTrue(userService.deleteUser(user1.getId()));
        Assert.assertNull(userService.findUser(user1.getId()));
    }



}
