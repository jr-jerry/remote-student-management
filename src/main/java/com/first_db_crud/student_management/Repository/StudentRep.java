package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface StudentRep extends JpaRepository<Student,Integer> {

   Optional<Student> findByName(String name);
   Optional<Student> findByAge(Integer age);
}
