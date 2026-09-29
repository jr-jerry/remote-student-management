package com.first_db_crud.student_management.Controller;

import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class StudentController {
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;
    @PostMapping("/create")
    public String createEndpoint(@RequestBody Student student){
        studentService.save(student);
        return "Save sucessfull";
    }
}
