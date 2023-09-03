package com.Agile.Library.repositories;

import com.Agile.Library.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
