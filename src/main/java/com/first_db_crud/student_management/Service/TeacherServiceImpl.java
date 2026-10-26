package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Teacher;
import com.first_db_crud.student_management.Repository.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;
    @Override
    public Teacher findTeacherByName(String name) {
        return teacherRepo.findTeacherByName(name).orElseThrow(()->new RuntimeException("Teacher not found"));
    }
}
