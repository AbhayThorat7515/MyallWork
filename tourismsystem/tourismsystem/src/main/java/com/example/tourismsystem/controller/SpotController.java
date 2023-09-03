package com.example.tourismsystem.controller;

import com.example.tourismsystem.dto.LocationDto;
import com.example.tourismsystem.dto.SpotDto;
import com.example.tourismsystem.exceptionutility.CommonException;
import com.example.tourismsystem.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/spot")
public class SpotController {
    @Autowired
    SpotService spotService;

    @RequestMapping(value = "/addSpot",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addSpot(@RequestBody @Valid SpotDto spotDto,@RequestParam("id") Long id, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw  new CommonException(bindingResult);
        }
        return ResponseEntity.ok().body(spotService.addSpot(spotDto,id));
    }


}
