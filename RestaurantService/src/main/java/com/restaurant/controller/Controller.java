package com.restaurant.controller;

import com.restaurant.service.ProductService;
import com.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class Controller {

    @Autowired
    ProductService productService;

    @Autowired
    ReservationService reservationService;


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

        if (authority.getAuthority().equals("ADMIN")) redirect.setViewName("redirect:http://localhost:1110/admin");
        else if (authority.getAuthority().equals("GUEST")) redirect.setViewName("redirect:http://localhost:1110/guest");
        else if (authority.getAuthority().equals("RESTAURANT")) redirect.setViewName("redirect:http://localhost:1110/restaurant");
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

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public ModelAndView homeData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(productService.findAllProducts());
        modelAndView.addObject(reservationService.findAllReservations());
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
