package com.Agile.Library.services;

import com.Agile.Library.dto.RackDto;
import com.Agile.Library.entities.Rack;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RackService {


    public void addRack(RackDto  rackDto);

    void deleteById(long rackNo);

  public  List<Rack> getAllRack();
}
