package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @PostMapping("/addDishToOrder/{id}")
    public String addDishToOrder(@PathVariable("id") Long id) {
        orderService.addOrder(id);
        return "redirect:/";
    }

}
