package com.Agile.Library.services;

import com.Agile.Library.dto.RackDto;
import com.Agile.Library.entities.Book;
import com.Agile.Library.entities.Rack;
import com.Agile.Library.repositories.RackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackServiceImp implements RackService{

    @Autowired
    private RackRepository rackRepository;

   //Add Rack Name
    @Override
    public void addRack(RackDto rackDto) {
        try {
            Rack rack = new Rack(rackDto.getRackName());
         System.out.println(rackDto.getRackName());
//            rack.setRackName(rack.getRackName());
//            System.out.println(rack.getRackName());
            rackRepository.save(rack);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    //delete by id
    @Override
    public void deleteById(long rackNo) {
        rackRepository.deleteById(rackNo);
    }


    //get all data
    @Override
    public List<Rack> getAllRack() {
        List<Rack> list=(List<Rack>)this.rackRepository.findAll();
        return list;
    }
}
