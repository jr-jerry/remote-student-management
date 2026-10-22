package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Aadhar;

public interface AadharService {
    Aadhar findByAadharNumber(String aadharNumber);
}
