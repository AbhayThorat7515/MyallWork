package com.example.tourismsystem.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserDto {
    @Pattern(regexp = "^[a-zA-Z]*$", message="name should contains only alphabet...plz check it!!")
    @NotEmpty(message="First Name should not be empty")

    private String firstName;
    @Pattern(regexp = "^[a-zA-Z]*$", message="name should contains only alphabet...plz check it!!")
    @NotEmpty(message="Last Name should not be empty")
    private String lastName;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "emails is not proper format ")
    @NotEmpty(message="email should not be empty")
    private String email;


    private Date dateOfJourney;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String email, Date dateOfJourney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfJourney = dateOfJourney;
    }

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
}
