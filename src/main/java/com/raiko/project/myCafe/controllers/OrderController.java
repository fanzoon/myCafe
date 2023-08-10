package com.raiko.project.myCafe.controllers;

import com.raiko.project.myCafe.dtos.BasketDTO;
import com.raiko.project.myCafe.dtos.OrderingDTO;
import com.raiko.project.myCafe.models.*;
import com.raiko.project.myCafe.services.impl.BasketServiceImpl;
import com.raiko.project.myCafe.services.impl.DeliveryTypeServiceImpl;
import com.raiko.project.myCafe.services.impl.OrderServiceImpl;
import com.raiko.project.myCafe.services.impl.PaymentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private DeliveryTypeServiceImpl deliveryTypeService;

    @Autowired
    private PaymentTypeServiceImpl paymentTypeService;

    @Autowired
    private BasketServiceImpl basketService;

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
        return "user/dish/orderIsProcessed";
    }

    @GetMapping("/basket")
    public String showBasket(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<BasketDTO> basketDTOs = basketService.getAllBasketDTO(user);
        model.addAttribute("listBasketDTO", basketDTOs);
        Double totalAmount = basketService.getTotalAmount(basketDTOs);
        model.addAttribute("totalAmount", totalAmount);
        Order order = orderService.getOrder();
        model.addAttribute("order", order);
        return "user/dish/basket";
    }
}
