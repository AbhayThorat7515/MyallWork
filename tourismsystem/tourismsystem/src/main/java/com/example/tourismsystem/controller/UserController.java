package com.example.tourismsystem.controller;

import com.example.tourismsystem.dto.SpotDto;
import com.example.tourismsystem.dto.UserDto;
import com.example.tourismsystem.exceptionutility.CommonException;
import com.example.tourismsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/booking",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> booking(@RequestParam("packageid") Long packageid, @RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw  new CommonException(bindingResult);
        }
        return ResponseEntity.ok().body(userService.booking(packageid,userDto));
    }

}
