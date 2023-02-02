package com.anto.ktool.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Error {

    private int errorCode;
    private String errMsg;
    private List<ErrorDetails> errorDetails;
}
