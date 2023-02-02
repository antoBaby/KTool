package com.anto.ktool.utils;

import lombok.Builder;
import org.springframework.http.HttpStatus;


public enum ErrorCode  {

    BAD_REQUEST(400, "BAD REQUEST"),
    NOT_FOUND(404,  "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    private final int value;
    private final String reasonPhrase;

    ErrorCode(int value,  String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value(){
        return this.value;
    }

    public String getReasonPhrase(){
        return this.reasonPhrase;
    }




}
