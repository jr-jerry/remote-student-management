package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Aadhar;
import com.first_db_crud.student_management.Entity.Student;

public interface AadharService {
    Aadhar findByAadharNumber(String aadharNumber);
    Student findStudentByAadharNumber(String aadharNumber);
}
