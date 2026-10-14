package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository 
public interface StudentRep extends JpaRepository<Student,Integer> {
   Optional<Student> findByName(String name);
}
