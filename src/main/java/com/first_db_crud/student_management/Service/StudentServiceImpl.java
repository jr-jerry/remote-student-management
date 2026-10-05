package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.DTO.StudentDTO;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Repository.StudentRep;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    public StudentServiceImpl(StudentRep studentRep) {
        this.studentRep = studentRep;
    }

    private final StudentRep studentRep;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student studentEntity=new Student();

        studentEntity.setName(studentDTO.getName());
        studentEntity.setAge(studentDTO.getAge());

        Student savedStudent=this.studentRep.save(studentEntity);
        return studentDTO;
    }
    @Override
    public void delete(String name) {
        Student student=studentRep.findByName(name)
                                  .orElseThrow(()->new RuntimeException("No user found with this name "));
        studentRep.deleteById(student.getId());
    }
    @Override
    public Student findByNameService(String name) {
      return this.studentRep.findByName(name)
                            .orElseThrow(()->new RuntimeException("No user Found with this name "));
    }
    @Override
    public Student updateStudenService(String name, Student updatedData) {
         Student student_in_DB=studentRep.findByName(name)
                 .orElseThrow(()->new RuntimeException("No user found with this name "));

         student_in_DB.setAge(updatedData.getAge());
         student_in_DB.setName(updatedData.getName());
         return studentRep.save(student_in_DB);
    }
}
