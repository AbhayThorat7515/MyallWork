package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.LocationDto;
import com.example.tourismsystem.dto.SpotDto;
import com.example.tourismsystem.entities.LocationEntity;
import com.example.tourismsystem.entities.SpotEntity;
import com.example.tourismsystem.exceptionutility.CommonException;
import com.example.tourismsystem.exceptionutility.CustomeException;
import com.example.tourismsystem.repository.LocationRepository;
import com.example.tourismsystem.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SpotServiceImpl implements SpotService{
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    SpotRepository spotRepository;

    @Override
    public SpotDto addSpot(SpotDto spotDto,Long id) {
        SpotEntity spotEntity=new SpotEntity();
        Optional<LocationEntity> optionalLocationEntity=locationRepository.findById(id);

        try {
            LocationEntity locationEntity = optionalLocationEntity.get();

            if (spotDto != null && optionalLocationEntity.isPresent()) {

                try {
                    spotEntity.setName(spotDto.getName());
                    spotEntity.setLocationEntity(locationEntity);
                    spotRepository.save(spotEntity);
                }catch (Exception e){
                    throw  new CustomeException(600,"Name already present ...plz insert correct data");

                }

            }
        }catch(NoSuchElementException e){
            throw  new CustomeException(500,"id not found");
        }
        return spotDto;
    }
}
