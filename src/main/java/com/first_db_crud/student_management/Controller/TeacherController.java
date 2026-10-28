package com.first_db_crud.student_management.Controller;

import com.first_db_crud.student_management.DTO.TeacherDTO;
import com.first_db_crud.student_management.Entity.Teacher;
import com.first_db_crud.student_management.Service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
    private final TeacherService  teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveTeacherEndpoint(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.saveTeacherService(teacherDTO));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllTeacherEndpoint() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeacher());
    }
}
