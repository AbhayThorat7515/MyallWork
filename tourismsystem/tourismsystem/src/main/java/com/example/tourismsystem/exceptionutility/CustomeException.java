package com.example.tourismsystem.exceptionutility;

import org.springframework.validation.BindingResult;

import java.util.List;

public class CustomeException extends RuntimeException {

    private int code;

    private String message;
    private List<ResponseErrorDto> errors;


    public CustomeException(String message) {
        super(message);
    }


    public CustomeException(String message, int code, List<ResponseErrorDto> errors) {
        super(message);
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public CustomeException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResponseErrorDto> getErrors() {
        return errors;
    }

    public void setErrors(List<ResponseErrorDto> errors) {
        this.errors = errors;
    }
}


