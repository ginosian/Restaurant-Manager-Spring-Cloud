package com.restaurant.admin.controller;

import com.restaurant.admin.model.Product;
import com.restaurant.admin.model.Reservation;
import com.restaurant.admin.model.Role;
import com.restaurant.admin.model.User;
import com.restaurant.admin.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * Created by Martha on 2/25/2017.
 */
@RestController
public class Controller {

    @Autowired
    Service service;

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
        modelAndView.addObject(allUsers());
        modelAndView.addObject(allProducts());
        modelAndView.addObject(allReservations());
        modelAndView.addObject(allRoles());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @ModelAttribute("allUsers")
    public List<User> allUsers() {
        return this.service.getAllUsers();
    }

    @ModelAttribute("allProducts")
    public List<Product> allProducts() {
        return this.service.getAllProducts();
    }

    @ModelAttribute("allReservations")
    public List<Reservation> allReservations() {
        return this.service.getAllReservations();
    }

    @ModelAttribute("allRoles")
    public List<Role> allRoles() {
        return this.service.getAllRoles();
    }
}
