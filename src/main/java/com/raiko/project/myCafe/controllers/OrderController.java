package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.OrderingDTO;
import com.raiko.project.myCafe.models.DeliveryType;
import com.raiko.project.myCafe.models.Dish;
import com.raiko.project.myCafe.models.PaymentType;
import com.raiko.project.myCafe.services.DeliveryTypeService;
import com.raiko.project.myCafe.services.impl.BasketServiceImpl;
import com.raiko.project.myCafe.services.impl.DeliveryTypeServiceImpl;
import com.raiko.project.myCafe.services.impl.OrderServiceImpl;
import com.raiko.project.myCafe.services.impl.PaymentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private BasketServiceImpl basketService;

    @Autowired
    private DeliveryTypeServiceImpl deliveryTypeService;

    @Autowired
    private PaymentTypeServiceImpl paymentTypeService;



    @PostMapping("/addDishToOrder/{id}")
    public String addDishToOrder(@PathVariable("id") Long id) {
        Dish dish = orderService.addOrder(id);
        return "redirect:/getAllDishOfCategory/" + dish.getDishCategory().getId();
    }


    @PostMapping("/addDishFromOrder/{id}")
    public String addDishFromOrder(@PathVariable("id") Long id) {
        Dish dish = orderService.addDishFromOrder(id);
        return "redirect:/";
    }

    @PostMapping("/removeDishFromOrder/{id}")
    public String removeDishFromOrder(@PathVariable("id") Long id) {
        Dish dish = orderService.removeDishFromOrder(id);
//        return "redirect:/" + dish.getDishCategory().getId();
        return "redirect:/";
    }

    @GetMapping ("/ordering/{orderId}")
    public String ordering(@PathVariable("orderId") Long orderId, Model model) {
        List<DeliveryType> deliveries = deliveryTypeService.getAllDeliveryType();
        model.addAttribute("deliveries", deliveries);
        List<PaymentType> payments = paymentTypeService.getAllPaymentType();
        model.addAttribute("payments", payments);
        model.addAttribute("orderId", orderId);
        return "user/dish/formForOrdering";
    }

    @PostMapping ("/ordering")
    public String saveOrdering(OrderingDTO orderingDTO) {
        orderService.changeStatusOrder(orderingDTO);
        return "redirect:/";
    }
}
