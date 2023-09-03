package com.Agile.Library.controllers;


import com.Agile.Library.dto.StudentDto;
import com.Agile.Library.entities.Student;
import com.Agile.Library.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {


    @Autowired

    private StudentService studentService;

    //Add Student
@RequestMapping(value ="/addStudent",method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentdto)
    {
        studentService.addStudent(studentdto);
        return ResponseEntity.ok().body("");
    }

    //Get Student
@RequestMapping(value = "/getStudent",method = RequestMethod.GET)
    public List<Student> getStudent(){
    return this.studentService.getAllStudent();
}

}
