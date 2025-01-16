package com.atapia.main.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TrainerDTO {
    private String idTrainer;
    private String firstName;
    private String surName;
    private String dni;
    private String specialization;
    private String phone;
    private Boolean state;
    private Date createdAt;
    private Date updatedAt;
}
