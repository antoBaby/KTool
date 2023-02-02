package com.anto.ktool.controller;

import com.anto.ktool.exception.DataValidationException;
import com.anto.ktool.model.Error;
import com.anto.ktool.model.dto.RegisterDTO;
import com.anto.ktool.service.AccountService;
import com.anto.ktool.utils.ResponseUtils;
import com.anto.ktool.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("account/")

public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ResponseUtils responseUtils;

    @Autowired
    ValidationUtils validationUtils;


    @GetMapping("register/{name}")
    public ResponseEntity accountRegister(@PathVariable String name) throws DataValidationException {



        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setName(name);
        registerDTO.setEmail(name);
        char[] password =new char[]{'a','b'};
        registerDTO.setPassword(password);

        ResponseEntity responseEntity = null;

//        validationUtils.checkValidation(bindingResult);

        Optional<RegisterDTO> savedResponse = Optional.ofNullable(accountService.registerAccount(registerDTO));
        if (savedResponse.isPresent()) {
            responseEntity = responseUtils.successResponse(savedResponse.get(), HttpStatus.CREATED);
        } else {
            responseEntity = responseUtils.failureResponse(new Error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }



}
