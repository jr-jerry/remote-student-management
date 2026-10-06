package com.first_db_crud.student_management.Controller;

import com.first_db_crud.student_management.DTO.StudentDTO;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Service.StudentService;
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
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createEndpoint(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
//        return "Save sucessfull";
    }
//    http://localhost:8080/api/user/update?name=gautam
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDTO updateEndpoint(@RequestParam String name,@RequestBody StudentDTO studentDTO){
        return studentService.updateStudenService(name,studentDTO);
//        return "Update succesfully";
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllEndpoint(){
        return studentService.getAll();
    }
}
