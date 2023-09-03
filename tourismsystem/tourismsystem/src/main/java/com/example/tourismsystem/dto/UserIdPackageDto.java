package com.example.tourismsystem.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class UserIdPackageDto {

 //   private UserDto user;
 private Date dateOfJourney;
    private String firstName;
    private String lastName;
    private String email;
    private Set<PackageDtos> packageDtoSet=new HashSet<>();
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



//    public UserDto getUser() {
//        return user;
//    }
//
//    public void setUser(UserDto user) {
//        this.user = user;
//    }


    public Set<PackageDtos> getPackageDtoSet() {
        return packageDtoSet;
    }

    public void setPackageDtoSet(Set<PackageDtos> packageDtoSet) {
        this.packageDtoSet = packageDtoSet;
    }

    public Date getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(Date dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }
}
