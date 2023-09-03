package com.Agile.Library.controllers;

import com.Agile.Library.dto.RackDto;
import com.Agile.Library.entities.Book;
import com.Agile.Library.entities.Rack;
import com.Agile.Library.services.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RackController {



    @Autowired
    private RackService rackService;

//getRack
@RequestMapping(value =  "/getRook", method = RequestMethod.GET)
public List<Rack> getRook()
{
    return this.rackService.getAllRack();
}

    //add rack
    @RequestMapping(value = "/addRack", method = RequestMethod.POST)
    public ResponseEntity<?> addRack(@RequestBody RackDto rackDto)
    {
        rackService.addRack(rackDto);
        return ResponseEntity.ok().body("");
    }

//delete rack
@RequestMapping(value = "/deleteRack/{rackNo}", method = RequestMethod.DELETE)
    public void deleteRack(@PathVariable("rackNo") long rackNo)
        {
            rackService.deleteById(rackNo);
        }

}
