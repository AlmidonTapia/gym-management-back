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
@Table(name = "tdailyRecord")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDailyRecord implements Serializable {

    @Id
    @Column(name = "idDailyRecord")
    private String idDailyRecord;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private TCustomer customer;

    @Column(name = "date")
    private Date date;

    
}
