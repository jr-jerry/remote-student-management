package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.DTO.StudentDTO;
import com.first_db_crud.student_management.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);
    void delete(String name);
    Student findByNameService(String name);
    StudentDTO updateStudenService(String name,StudentDTO studentDTO);
    List<StudentDTO> getAll();
}
