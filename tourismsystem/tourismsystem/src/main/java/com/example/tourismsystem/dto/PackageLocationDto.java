package com.example.tourismsystem.dto;

import java.util.List;
import java.util.Set;

public class PackageLocationDto {

    private String packageName;
    private String duration;
    private Long price;
    private Set<LocationDto> locationDtoList;

    public PackageLocationDto() {
    }

    public PackageLocationDto(String packageName, String duration, Long price, Set<LocationDto> locationDtoList) {
        this.packageName = packageName;
        this.duration = duration;
        this.price = price;
        this.locationDtoList = locationDtoList;
    }

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

    public Set<LocationDto> getLocationDtoList() {
        return locationDtoList;
    }

    public void setLocationDtoList(Set<LocationDto> locationDtoList) {
        this.locationDtoList = locationDtoList;
    }
}
