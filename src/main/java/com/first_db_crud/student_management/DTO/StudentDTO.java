package com.first_db_crud.student_management.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonNaming;

@Setter
@Getter
public class StudentDTO {
    private String name;
//    @JsonProperty( "user age ")
    @JsonIgnore
    private Integer age;
}
