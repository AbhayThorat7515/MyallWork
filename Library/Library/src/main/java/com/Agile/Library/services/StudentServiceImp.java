package com.Agile.Library.services;

import com.Agile.Library.dto.StudentDto;
import com.Agile.Library.entities.Book;
import com.Agile.Library.entities.Student;
import com.Agile.Library.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    //FOR ADD STUDENT DATA (FOR POST )
    @Override
    public void addStudent(StudentDto studentdto) {
        try {
            Student student = new Student();                //CREATE OBJECT OF STUDENT AND ASSIGN THE VALUE
            student.setStud_name(studentdto.getStudName());
            studentRepository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
}


//FOR GET STUDENT DATA (FOR GET )

    @Override
    public List<Student> getAllStudent(){
        List<Student> list=(List<Student>)this.studentRepository.findAll();
        return list;
    }

}