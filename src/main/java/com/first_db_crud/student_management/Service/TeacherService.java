package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Teacher;

public interface TeacherService {
    Teacher findTeacherByName(String name);
}
