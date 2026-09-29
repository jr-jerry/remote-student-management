package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRep extends JpaRepository<Student,Integer> {
}
