package com.atapia.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atapia.main.entity.TCustomer;

public interface CustomerRepository extends JpaRepository<TCustomer, String>{

}
