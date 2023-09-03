package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.LocationDto;
import com.example.tourismsystem.entities.LocationEntity;
import com.example.tourismsystem.exceptionutility.CommonException;
import com.example.tourismsystem.exceptionutility.CustomeException;
import com.example.tourismsystem.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public LocationDto addLocation(LocationDto locationDto) {

        LocationEntity locationEntity = new LocationEntity();



//        try {
//
//            Optional<LocationEntity> optionalLocationEntity = locationRepository.findBylocation(locationDto.getLocation());
//            LocationEntity locationEntity1 = optionalLocationEntity.get();
//            if (optionalLocationEntity.isPresent()) {
//                throw new CustomeException(500, "location already present...can't insert again");
//            }
//        }

                if ((locationDto != null)) {


                    try {
                        locationEntity.setLocation(locationDto.getLocation());
                        locationRepository.save(locationEntity);
                    }catch (Exception e){
                        throw new CustomeException(500, "location already present...can't insert again");
                    }
                }




        return locationDto;
    }


    @Override
    public Integer deleteLocation(Long id) {


        locationRepository.deleteById(id);
        return 1;
    }
}
