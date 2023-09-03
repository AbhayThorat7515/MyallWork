package com.example.tourismsystem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class PackageDto {

    @Pattern(regexp = "^[a-zA-Z]*$", message="name should contains only alphabet...plz check it!!")
    @NotEmpty(message = "package must not be empty")
    private String packageName;

    @NotEmpty(message = "duration must not be empty")
    private String duration;
    private Long price;


    private Set<LocationDto> locationDtoSet;
    public PackageDto() {
    }

    public PackageDto(String packageName, String duration, Long price) {
        this.packageName = packageName;
        this.duration = duration;
        this.price = price;
    }

    public Set<LocationDto> getLocationDtoSet() {
        return locationDtoSet;
    }

    public void setLocationDtoSet(Set<LocationDto> locationDtoSet) {
        this.locationDtoSet = locationDtoSet;
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
}
