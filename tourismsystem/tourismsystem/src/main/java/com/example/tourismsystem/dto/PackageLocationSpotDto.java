package com.example.tourismsystem.dto;

import java.util.Set;

public class PackageLocationSpotDto {


    private String packageName;
    private String duration;
    private Long price;
    private Set<LocationDto>  locationDtos;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<LocationDto> getLocationDtos() {
        return locationDtos;
    }

    public void setLocationDtos(Set<LocationDto> locationDtos) {
        this.locationDtos = locationDtos;
    }
}
