package com.atapia.main.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ttrainer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TTrainer implements Serializable{
    @Id
    @Column(name = "idTrainer", length = 36)
    private String idTrainer;

    @Column(name = "firstName", nullable = false, length = 70)
    private String firstName;
    
    @Column(name = "surName", nullable = false, length = 40)
    private String surName;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "specialization", nullable = false, length = 70)
    private String specialization;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "state")
    private Boolean state;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

}
