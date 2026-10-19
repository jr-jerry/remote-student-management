package com.first_db_crud.student_management.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.first_db_crud.student_management.Entity.Aadhar;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonNaming;

@Setter
@Getter
public class StudentDTO {
    @NotEmpty(message = "invalid name")
    private String name;
    @Min(value = 10, message = "Age should be greater then 10")
    private Integer age;
    private Aadhar aadhar;
}
