package com.Agile.Library.controllers;


import com.Agile.Library.dto.ShelfDto;
import com.Agile.Library.services.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShelfController {

    @Autowired
    private ShelfService shelfService;
    //add Shelf
    @RequestMapping(value = "/addShelf", method = RequestMethod.POST)
    public ResponseEntity<?> addShelf(@RequestBody ShelfDto shelfDto)
    {
        shelfService.addShelf(shelfDto);
        return ResponseEntity.ok().body("");
    }

    //get shelf


    //Delete shelf

}
