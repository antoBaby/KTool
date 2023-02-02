package com.anto.ktool.utils;

import com.anto.ktool.model.dto.RegisterDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T mapObject(RegisterDTO registerDTO, Class aClass) {
        return (T) objectMapper.convertValue(registerDTO, aClass);
    }
}
