package com.example.tourismsystem.controller;

import com.example.tourismsystem.dto.LocationDto;
import com.example.tourismsystem.exceptionutility.CommonException;
import com.example.tourismsystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/addLocation",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addLocation(@RequestBody @Valid LocationDto locationDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw  new CommonException(bindingResult);
        }
        return ResponseEntity.ok().body(locationService.addLocation(locationDto));
    }



    @RequestMapping(value = "/deleteLocation",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteLocation(@RequestParam("locationid") Long locationid) {


        return ResponseEntity.ok().body("deleted succefully");
    }
}

