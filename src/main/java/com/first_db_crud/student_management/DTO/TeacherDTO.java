package com.first_db_crud.student_management.DTO;

import com.first_db_crud.student_management.Entity.Student;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDTO {
    private String name;
    private String subject;
}
