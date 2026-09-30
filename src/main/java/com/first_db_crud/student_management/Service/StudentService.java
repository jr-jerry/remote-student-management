package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Student;

import java.util.Optional;

public interface StudentService {
    Student save(Student studentData);
    void delete(String name);
    Student findByNameService(String name);
    Student updateStudenService(String name,Student updatedData);

}
