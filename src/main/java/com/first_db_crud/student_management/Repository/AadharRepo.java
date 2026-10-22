package com.first_db_crud.student_management.Repository;

import com.first_db_crud.student_management.Entity.Aadhar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AadharRepo extends JpaRepository<Aadhar,Integer> {
    @Query(value="select a from Aadhar AS a JOIN FETCH a.student  where a.aadhar_no=:aadhar_no")
    Optional<Aadhar> findByAadharNo(@Param("aadhar_no") String aadhar_no);
}
