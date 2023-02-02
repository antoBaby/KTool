package com.anto.ktool.utils;

import com.anto.ktool.model.Error;
import com.anto.ktool.model.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {

    public ResponseEntity successResponse(Object responseData, HttpStatus statusCode) {
        ResponseDTO response = new ResponseDTO();
        response.setData(responseData);
        response.setTransactionSuccess(true);
        return ResponseEntity.status(statusCode).body(response);
    }

    public ResponseEntity failureResponse(Error error, HttpStatus statusCode) {
        ResponseDTO response = new ResponseDTO();
        response.setTransactionSuccess(false);
        response.setError(error);
        return ResponseEntity.status(statusCode).body(response);
    }

    public ResponseEntity failureResponse(String message, HttpStatus statusCode) {
        Error error =new Error();
        error.setErrMsg(message);
        error.setErrorCode(ErrorCode.INTERNAL_SERVER_ERROR.value());
        ResponseDTO response = new ResponseDTO();
        response.setTransactionSuccess(false);
        response.setError(error);
        return ResponseEntity.status(statusCode).body(response);
    }
}
