package com.first_db_crud.student_management.Controller;

import com.first_db_crud.student_management.Entity.Aadhar;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Service.AadharService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/aadhar")
@AllArgsConstructor
public class AadharController {
    private AadharService  aadharService;
    @GetMapping("/aadhar-no")
    public Aadhar getAadharNo(@RequestParam String aadhar_no){
        return aadharService.findByAadharNumber(aadhar_no);
    }
    @GetMapping("/search-student")
    public ResponseEntity<?> getStudentByAadharNumber(@RequestParam String aadhar_no){
        Student student=aadharService.findStudentByAadharNumber(aadhar_no);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    //create aadhar ! (Edge same name user should not create aadhar ! )
    // update aadhar !
    // delete aadhar !
}
