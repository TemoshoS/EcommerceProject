package com.temosho.application.controller;

import com.temosho.application.model.Order;
import com.temosho.application.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);        
        return "order saved succesfully";
    }

    
  

    @CrossOrigin
    @RequestMapping(value = "/customerorder/{username}", method = RequestMethod.GET)
    public List<Order> customerOrders(@PathVariable String username) {
        return this.orderService.getCustomerOrders(username);

    }
}

