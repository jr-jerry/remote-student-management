package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.DTO.TeacherDTO;
import com.first_db_crud.student_management.Entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findTeacherByName(String name);
    Teacher saveTeacherService(TeacherDTO teacherDTO);
    List<Teacher> getAllTeacher();
}
