package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.models.User;
import com.raiko.project.myCafe.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @PostMapping("/addDishToOrder/{id}")
    public String addDishToOrder(@PathVariable("id") Long id, Principal principal) {
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        orderService.addOrder(id, user);
        return "redirect:/";
    }
}
