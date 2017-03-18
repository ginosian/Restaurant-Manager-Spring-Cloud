package com.user.dataLoader;

import com.user.dto.Role;
import com.user.service.UserService;
import com.user.util.MockedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Martha on 3/18/2017.
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Role admin = userService.createRole("ADMIN");
        Role restaurant = userService.createRole("RESTAURANT");
        Role user = userService.createRole("USER");

        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);
        userService.createUser(MockedData.userName(), MockedData.password(), user);

        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);
        userService.createUser(MockedData.userName(), MockedData.password(), admin);

        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
        userService.createUser(MockedData.userName(), MockedData.password(), restaurant);
    }
}
