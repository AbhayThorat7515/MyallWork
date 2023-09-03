package com.Agile.Library.dto;

public class StudentDto {





    private String stud_name;

    public String getStudName() {
        return stud_name;
    }

    public StudentDto() {
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "stud_name='" + stud_name + '\'' +
                '}';
    }
}
