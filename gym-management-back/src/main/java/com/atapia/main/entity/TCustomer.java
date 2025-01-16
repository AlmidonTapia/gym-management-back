package com.atapia.main.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tcustomer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCustomer implements Serializable {

    @Id
    @Column(name = "idCustomer")
    private String idCustomer;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surName")
    private String surName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "state")
    private Boolean state;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    // Relaciones con otras entidades
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<TMembership> memberships;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<TDailyRecord> dailyRecords;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<TPayment> payments;
}
