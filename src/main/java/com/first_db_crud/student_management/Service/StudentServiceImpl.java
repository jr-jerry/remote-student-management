package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.DTO.StudentDTO;

import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Entity.Teacher;
import com.first_db_crud.student_management.Exception.StudentNotFoundException;
import com.first_db_crud.student_management.Repository.StudentRep;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{


    public StudentServiceImpl(ModelMapper modelMapper, StudentRep studentRep, TeacherService teacherService) {
        this.modelMapper = modelMapper;
        this.studentRep = studentRep;
        this.teacherService = teacherService;
    }

    private final ModelMapper modelMapper;
    private final StudentRep studentRep;
    private final TeacherService teacherService;

    @Override
    public StudentDTO save(StudentDTO studentDTO)  {
         Student studentEntity=this.modelMapper.map(studentDTO,Student.class);
         Teacher existTeacher=null;
         try{
               existTeacher=teacherService.findTeacherByName(studentDTO.getTeacher().getName());
         }catch(RuntimeException e){
            log.info("Teacher not found");
         }
         if(existTeacher==null){
             existTeacher=this.modelMapper.map(studentDTO.getTeacher(),Teacher.class);
         }

         studentEntity.setTeacher(existTeacher);

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
