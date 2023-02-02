package com.anto.ktool.controller;

import com.anto.ktool.exception.DataValidationException;
import com.anto.ktool.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @Autowired
    ResponseUtils responseUtils;

    @ExceptionHandler(value = DataValidationException.class)
    public void dataValidationException(DataValidationException exception) {
        responseUtils.failureResponse(exception.getError(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = Exception.class)
    public void globalException(Exception exception) {
        responseUtils.failureResponse(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
