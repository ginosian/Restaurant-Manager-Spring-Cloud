package com.restaurant.authserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Martha on 2/28/17.
 */
@Controller
public class AuthController {


    @GetMapping("/")
    public String home() {
        return "login";
    }
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

}
