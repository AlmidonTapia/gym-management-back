package com.atapia.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atapia.main.entity.TPayment;

public interface PaymentRepository extends JpaRepository<TPayment, String> {

}
