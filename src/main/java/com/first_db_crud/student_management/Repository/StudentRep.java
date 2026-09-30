package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRep extends JpaRepository<Student,Integer> {
//    select * from Student where name=?
   Optional<Student> findByName(String name);
}
