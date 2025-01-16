package com.atapia.main.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tmembership")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TMembership implements Serializable {
     @Id
    @Column(name = "idMembership", length = 36)
    private String idMembership;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private TCustomer customer;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;
}
