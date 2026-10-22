package com.first_db_crud.student_management.Service;

import com.first_db_crud.student_management.Entity.Aadhar;
import com.first_db_crud.student_management.Entity.Student;
import com.first_db_crud.student_management.Repository.AadharRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AadharServiceImpl implements AadharService {
    private AadharRepo aadharRepo;
    @Override
    public Aadhar findByAadharNumber(String aadharNumber) {
        Aadhar aadharEntity = aadharRepo.findByAadharNo(aadharNumber).orElseThrow(() -> new RuntimeException("Aadhar not found"));
        System.out.println("Aadhar:" + aadharEntity);
        return aadharEntity;

    }

    @Override
    public Student findStudentByAadharNumber(String aadharNumber) {
        Aadhar aadharEntity=findByAadharNumber(aadharNumber);
        Student studentEntity=new Student();
        studentEntity.setAge(aadharEntity.getStudent().getAge());
        studentEntity.setName(aadharEntity.getStudent().getName());
        return studentEntity;
    }
}
