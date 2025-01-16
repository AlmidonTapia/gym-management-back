package com.atapia.main.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tpayment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  TPayment implements Serializable {
    @Id
    @Column(name = "idPayment", length = 36)
    private String idPayment;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private TCustomer customer;

    @ManyToOne
    @JoinColumn(name = "membership_id", nullable = false)
    private TMembership membership;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;
}
