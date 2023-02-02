package com.anto.ktool.exception;

import com.anto.ktool.model.Error;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataValidationException extends Exception {
    private Error error;

    public DataValidationException(Error error) {
        super("");
        this.error = error;
    }




}
