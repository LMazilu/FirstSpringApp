package com.stivalePrimaverile.SpringApp.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(new Student(1L, "Pippo", 23, LocalDate.of(2020, 1, 1), "Pippo@gmail.com")
                ,new Student(2L, "Pluto", 23, LocalDate.of(2021, 1, 1), "Pluto@yahoo.it")
                ,new Student(3L, "Paperino", 23, LocalDate.of(2022, 1, 1), "Paperino@outlook.en")
        );
    }
}
