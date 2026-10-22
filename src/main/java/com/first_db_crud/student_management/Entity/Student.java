package com.first_db_crud.student_management.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "aadhar")
@Table(name = "student_tb")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
//    @JsonIgnore
    private Integer age;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Aadhar adhar;
}
