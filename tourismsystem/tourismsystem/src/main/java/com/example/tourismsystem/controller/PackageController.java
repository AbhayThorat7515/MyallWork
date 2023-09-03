package com.example.tourismsystem.controller;


import com.example.tourismsystem.dto.LocationDto;
import com.example.tourismsystem.dto.PackageDto;
import com.example.tourismsystem.exceptionutility.CommonException;
import com.example.tourismsystem.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/package")
public class PackageController {
    @Autowired
    PackageService packageService;


    @RequestMapping(value = "/createPackage",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createPackage(@RequestBody @Valid PackageDto packageDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw  new CommonException(bindingResult);
        }
        return ResponseEntity.ok().body(packageService.createPackage(packageDto));
    }



    @RequestMapping(value = "/addPackageAndLocation",method = RequestMethod.POST)
    public ResponseEntity<?> addPackageAndLocation(@RequestParam("packageid") Long packageid,@RequestParam("locationid") Long locationid ) {


        packageService.addPackageandLOcation(packageid,locationid);
        return ResponseEntity.ok().body("added succefully");
    }


    @RequestMapping(value = "/listOfPackage",method = RequestMethod.GET,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> listOfPackage() {



        return ResponseEntity.ok().body( packageService.listOfPackage());
    }


    @RequestMapping(value = "/getHistoryOfUser",method = RequestMethod.GET,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getHistoryOfUser(@RequestParam("userid") Long userid) {



        return ResponseEntity.ok().body(packageService.getPackageDeatils(userid));
    }

    @RequestMapping(value = "/listofPackageByUserId",method = RequestMethod.GET)
    public ResponseEntity<?> listofPackageByUserId(@RequestParam("userid") Long userid) {

        return ResponseEntity.ok().body(packageService.listOfPackageByUserId(userid));
    }


    @RequestMapping(value = "/listOfLocationByPackageid",method = RequestMethod.GET)
    public ResponseEntity<?> listOfLocationByPackageid(@RequestParam("packageid") Long packageid) {

        return ResponseEntity.ok().body(packageService.listOfLocationByPackage(packageid));
    }


    @RequestMapping(value = "/getLocationandSpotBypackageId",method = RequestMethod.GET)
    public ResponseEntity<?> getLocationandSpotBypackageId(@RequestParam("packageid") Long packageid) {

        return ResponseEntity.ok().body(packageService.getLoacationSpotbyPackageId(packageid));
    }


}
