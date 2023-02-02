package com.anto.ktool.utils;

import com.anto.ktool.exception.DataValidationException;
import com.anto.ktool.model.Error;
import com.anto.ktool.model.ErrorDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationUtils {


    public void checkValidation(BindingResult bindingResult) throws DataValidationException {

        if (bindingResult.hasErrors()) {
            Error error = new Error();
            List<ErrorDetails> details = new ArrayList<>();
            bindingResult.getAllErrors().forEach(eror -> {
                details.add(new ErrorDetails(ErrorCode.BAD_REQUEST, eror.getObjectName(), eror.getDefaultMessage()));
            });
            error.setErrorCode(ErrorCode.BAD_REQUEST.value());
            error.setErrorDetails(details);
            error.setErrMsg(ErrorCode.BAD_REQUEST.getReasonPhrase());
            throw new DataValidationException(error);
        }

    }
}
