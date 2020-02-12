package com.temosho.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.temosho.application.model.Payment;
public interface PaymentRepository  extends JpaRepository<Payment, Integer>{

}
