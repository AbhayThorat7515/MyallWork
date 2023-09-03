package com.example.tourismsystem.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SpotDto {

    @Pattern(regexp = "^[a-zA-Z]*$", message="name should contains only alphabet...plz check it!!")
    @NotEmpty(message = "name must not be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
