package com.example.tourismsystem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

public class LocationDto {
    @Pattern(regexp = "^[a-zA-Z]*$", message = "name should contains only alphabet...plz check it!!")
    @NotEmpty(message = "Name should not be empty")
    private String location;

    private List<SpotDto> spotDtos;
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<SpotDto> getSpotDtos() {
        return spotDtos;
    }

    public void setSpotDtos(List<SpotDto> spotDtos) {
        this.spotDtos = spotDtos;
    }
}
