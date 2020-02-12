package com.temosho.application.services;

import com.temosho.application.model.Payment;
import com.temosho.application.repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;
            
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }

    public Payment updateDeliveryStatus(Payment payment) {
        return paymentRepository.save(payment);
    }
    
}