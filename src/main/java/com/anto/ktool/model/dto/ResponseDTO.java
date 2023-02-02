package com.anto.ktool.model.dto;

import com.anto.ktool.model.Error;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Setter
@Getter
public class ResponseDTO {

    @CreationTimestamp
    private Date responseTime;
    private boolean transactionSuccess;
    private Error error;
    private Object data;


}
