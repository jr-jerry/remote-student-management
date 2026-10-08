package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.DTO.StudentDTO;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Exception.StudentNotFoundException;
import com.first_db_crud.student_management.Repository.StudentRep;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    public StudentServiceImpl(ModelMapper modelMapper, StudentRep studentRep) {
        this.modelMapper = modelMapper;
        this.studentRep = studentRep;
    }

    private final ModelMapper modelMapper;
    private final StudentRep studentRep;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
         Student studentEntity=this.modelMapper.map(studentDTO,Student.class);

        Student savedStudent=this.studentRep.save(studentEntity);
        return this.modelMapper.map(savedStudent,StudentDTO.class);
    }
    @Override
    public void delete(String name) {
        Student student=studentRep.findByName(name)
                                  .orElseThrow(()->new StudentNotFoundException("Student not found"));
        studentRep.deleteById(student.getId());
    }
    @Override
    public Student findByNameService(String name) {
      return this.studentRep.findByName(name)
                            .orElseThrow(()->new StudentNotFoundException("Student not found"));
    }
    @Override
    public StudentDTO updateStudenService(String name, StudentDTO studentDTO) {
         Student student_in_DB=studentRep.findByName(name)
                 .orElseThrow(()->new StudentNotFoundException("Student not found"));

         student_in_DB.setAge(studentDTO.getAge());
         student_in_DB.setName(studentDTO.getName());

         Student savedStudent=studentRep.save(student_in_DB);
        return this.modelMapper.map(savedStudent, StudentDTO.class);

    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRep.findAll().stream().map(entity->modelMapper.map(entity,StudentDTO.class)).toList();
    }
}
