package com.atapia.main.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerDTO {
    private String idCustomer;
    private String firstName;
    private String surName;
    private String dni;
    private String phone;
    private int age;
    private Boolean gender;
    private Boolean state;
    private Date createdAt;
    private Date updatedAt;


}
