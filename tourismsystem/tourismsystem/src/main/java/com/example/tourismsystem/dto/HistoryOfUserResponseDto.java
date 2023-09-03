package com.example.tourismsystem.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HistoryOfUserResponseDto {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfJourney;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    private Set<PackageDto> packageDto=new HashSet<>();
   // private Set<LocationDto> locationDtos=new HashSet<>();
   // private Set<SpotDto> spotDtoset=new  HashSet<>();





    public Set<PackageDto> getPackageDto() {
        return packageDto;
    }

    public void setPackageDto(Set<PackageDto> packageDto) {
        this.packageDto = packageDto;
    }

//    public Set<LocationDto> getLocationDtos() {
//        return locationDtos;
//    }
//
//    public void setLocationDtos(Set<LocationDto> locationDtos) {
//        this.locationDtos = locationDtos;
//    }
//
//    public Set<SpotDto> getSpotDtoset() {
//        return spotDtoset;
//    }
//
//    public void setSpotDtoset(Set<SpotDto> spotDtoset) {
//        this.spotDtoset = spotDtoset;
//    }
}
