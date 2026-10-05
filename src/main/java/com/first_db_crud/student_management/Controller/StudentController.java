package com.first_db_crud.student_management.Controller;

import com.first_db_crud.student_management.DTO.StudentDTO;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Service.StudentService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createEndpoint(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
//        return "Save sucessfull";
    }
//    http://localhost:8080/api/user/update?name=gautam
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String updateEndpoint(@RequestParam String name,@RequestBody Student studentData){
        studentService.updateStudenService(name,studentData);
        return "Update succesfully";
    }
}
