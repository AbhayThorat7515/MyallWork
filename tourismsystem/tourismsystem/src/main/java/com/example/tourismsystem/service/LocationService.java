package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.LocationDto;

public interface LocationService {

    public LocationDto addLocation(LocationDto locationDto);

    public  Integer deleteLocation(Long id);
}
