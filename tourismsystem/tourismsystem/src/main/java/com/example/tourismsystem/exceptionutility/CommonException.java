package com.example.tourismsystem.exceptionutility;

import org.springframework.validation.BindingResult;

import java.util.List;

public class CommonException extends RuntimeException{

    private int code;

    private String message;
    private List<ResponseErrorDto> errors;
    BindingResult bindingResult;

    public CommonException(String message) {
        super(message);
    }

    public CommonException( BindingResult bindingResult) {
    //    super(message);
        this.bindingResult = bindingResult;
    }

    public CommonException(String message, int code, List<ResponseErrorDto> errors) {
        super(message);
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public CommonException( int code,String message) {
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

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
