package com.example.tourismsystem.exceptionutility;

import com.example.tourismsystem.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CommonExceptionHandler {


    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> getCommonException(CommonException commonException){

        List<FieldError> fieldErrorList=commonException.getBindingResult().getFieldErrors();

        List<ResponseErrorDto> responseErrorDtoList =new ArrayList<>();
        for(FieldError fieldError:fieldErrorList){
            ResponseErrorDto responseErrorDto=new ResponseErrorDto();
            responseErrorDto.setErrorMessage(fieldError.getField());
            responseErrorDto.setFieldName(fieldError.getDefaultMessage());
            responseErrorDtoList.add(responseErrorDto);
        }
        return ResponseEntity.ok().body(new ResponseDto(commonException.getCode(),commonException.getMessage(),fieldErrorList));

    }


    @ExceptionHandler(CustomeException.class)
    public ResponseEntity<?> getCommonException(CustomeException customeException) {


        return ResponseEntity.ok().body(new ResponseDto(customeException.getCode(),customeException.getMessage(),"wrong input"));

    }


    }
