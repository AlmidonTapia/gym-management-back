package com.atapia.main.service.customer.request;


import lombok.Data;

@Data
public class RequestInsert {
    private String firstName;

    private String surName;

    private String dni;

    private String phone;

    private int age;

    private Boolean gender;
    
    private Boolean state;

}
