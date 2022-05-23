package com.stivalePrimaverile.SpringApp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Pippo = new Student(1L, "Pippo", 23, LocalDate.of(2020, 1, 1), "Pippo@gmail.com");
            Student Pluto = new Student(2L, "Pluto", 23, LocalDate.of(2021, 1, 1), "Pluto@yahoo.it");
            Student Paperino = new Student(3L, "Paperino", 23, LocalDate.of(2022, 1, 1), "Paperino@outlook.en");

            studentRepository.saveAll(List.of(Pippo,Pluto,Paperino));
        };
    }
}
