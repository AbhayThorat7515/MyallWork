package com.Agile.Library.services;

import com.Agile.Library.dto.StudentDto;
import com.Agile.Library.entities.Student;

import java.util.List;

public interface StudentService {

   //Add student
    public void addStudent(StudentDto studentDto);


    //Get Student
    public List<Student> getAllStudent();



}
