package com.temosho.application.services;

import com.temosho.application.model.Order;
import com.temosho.application.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order) {

        orderRepository.save(order);
    }

    

    public List<Order> getAllOrders() {

        return this.orderRepository.findAll();
    }
    
    
  
     public List<Order> getCustomerOrders(String username){
    
        List<Order> orders = this.getAllOrders();
        List<Order> customerOrders = new ArrayList<>();
        
        if(!orders.isEmpty()){
        
            for (int i = 0; i < orders.size(); i++) {
                
                if(orders.get(i).getCustomerName()== username){
                
                    customerOrders.add(orders.get(i));
                }
            }
            
        }
        
        return customerOrders;
        
    }

    
}