package com.temosho.application.controller;

import com.temosho.application.model.Payment;
import com.temosho.application.services.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;
    
    @CrossOrigin
    @RequestMapping (value = "/all", method = RequestMethod.GET)
    public List <Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }
    
    //payment
    @CrossOrigin
    @RequestMapping (value = "/save", method = RequestMethod.POST)
    public String savePayment(@RequestBody Payment payment){
        paymentService.addPayment(payment);
        return "saved successfully";
    }
    
   
    
}