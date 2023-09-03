package com.example.tourismsystem.service;

import com.example.tourismsystem.dto.LocationDto;
import com.example.tourismsystem.dto.SpotDto;

public interface SpotService {
    public SpotDto addSpot(SpotDto spotDto,Long id);
}
