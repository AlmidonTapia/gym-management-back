package com.atapia.main.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DailyRecordDTO {
    private String idDailyRecord;
    private String customerId;
    private Date date;

}
