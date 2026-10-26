package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    Optional<Teacher> findTeacherByName(String name);
}
