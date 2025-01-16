package com.atapia.main.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PaymentDTO {
    private String idPayment;
    private String customer_id;
    private String membership_id;
    private BigDecimal amount;
    private Date payment_date;
    private String payment_method;
    private Date createdAt;
    private Date updatedAt;
}
