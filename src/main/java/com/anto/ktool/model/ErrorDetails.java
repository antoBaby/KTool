package com.anto.ktool.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private Object errorCode;
    private String detail;
    private String additionalInfo;


}
