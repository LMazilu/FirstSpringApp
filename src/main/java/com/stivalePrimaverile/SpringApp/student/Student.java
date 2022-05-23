package com.stivalePrimaverile.SpringApp.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private LocalDate dob;
    private String email;

    public Student(String name, Integer age, LocalDate dob, String email) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

}
