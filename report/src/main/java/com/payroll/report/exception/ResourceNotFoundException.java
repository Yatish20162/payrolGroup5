package com.payroll.report.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String entity, String fieldName, Long fieldVale){
        super(entity + " with " + fieldName + ": " + fieldVale + "is not found");
    }
}