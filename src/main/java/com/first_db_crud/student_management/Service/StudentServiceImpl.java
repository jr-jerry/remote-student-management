package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Repository.StudentRep;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    public StudentServiceImpl(StudentRep studentRep) {
        this.studentRep = studentRep;
    }

    private final StudentRep studentRep;

    @Override
    public void save(Student studentData) {
        this.studentRep.save(studentData);
    }
}
