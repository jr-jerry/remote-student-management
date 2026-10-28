package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.DTO.TeacherDTO;
import com.first_db_crud.student_management.Entity.Teacher;
import com.first_db_crud.student_management.Repository.TeacherRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;
    private final ModelMapper modelMapper;

    @Override
    public Teacher findTeacherByName(String name) {
        return teacherRepo.findTeacherByName(name).orElseThrow(()->new RuntimeException("Teacher not found"));
    }

    @Override
    public Teacher saveTeacherService(TeacherDTO teacherDTO) {

        return teacherRepo.save(this.modelMapper.map(teacherDTO, Teacher.class));
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return  teacherRepo.findAll();
    }
}
