package com.booking.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class AdminController {

    @GetMapping("/")
    @ResponseBody
    public String test(Principal principal) {
        String name = principal.getName();
        return "<html><h1>Welcome to the Admin home page!</h1><html/>" + name;
    }

    @GetMapping("/route")
    public ModelAndView routeHomeUrl(Principal principal) {
        OAuth2Authentication user = (OAuth2Authentication)principal;
        ModelAndView redirect = new ModelAndView();
        if (user == null || user.getAuthorities().size() == 0) {
            redirect.setViewName("login");
            redirect.addObject(notAuthenticated());
            return redirect;
        }
        GrantedAuthority authority = user.getAuthorities().iterator().next();

        if (authority.getAuthority().equals("ADMIN")) redirect.setViewName("redirect:http://localhost:1110/api/restaurants");
        else if (authority.getAuthority().equals("USER")) redirect.setViewName("redirect:http://localhost:1110/api/restaurants");
        else if (authority.getAuthority().equals("RESTAURANT")) redirect.setViewName("redirect:http://localhost:1110/api/restaurant/1");
        else {
            redirect.setViewName("login");
            redirect.addObject(unknownAuthority());
        }
        return redirect;
    }

    @ModelAttribute("error")
    public String notAuthenticated() {
        return "You need to login";
    }
    @ModelAttribute("error")
    public String unknownAuthority() {
        return "Sorry. Unknown authority. Login please...";
    }

}
