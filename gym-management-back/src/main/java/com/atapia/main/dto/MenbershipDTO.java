package com.atapia.main.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MenbershipDTO {
    private String idMembership;
    private String customer_id;
    private Date start_date;
    private Date expiration_date;
    private Boolean status;
    private Date createdAt;
    private Date updatedAt;
}
