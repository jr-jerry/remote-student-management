package com.first_db_crud.student_management.Controller;

import com.first_db_crud.student_management.DTO.StudentDTO;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Service.StudentService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class StudentController {
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;

    @PostMapping("/create")
    public StudentDTO createEndpoint(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudentOnly(studentDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEndpoint(@RequestParam String name,@Valid @RequestBody StudentDTO studentDTO){
         return  new ResponseEntity<StudentDTO>(studentService.updateStudenService(name,studentDTO), HttpStatus.OK);
    }
    @PutMapping("/assing-teacher")
    public ResponseEntity<?> assingTeacherEndpoint(@RequestParam String teacherName,@RequestParam String studentName){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.assingTeacherStudent(teacherName,studentName));
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllEndpoint(){
        return studentService.getAll();
    }
}
