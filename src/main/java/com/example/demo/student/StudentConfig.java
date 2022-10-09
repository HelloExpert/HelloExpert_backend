package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student a = new Student(
                    "Hans",
                    "hans.sprengers@fontys.nl",
                    LocalDate.of(1988, 10, 19), 33
            );

            Student b = new Student(
                    "Wim",
                    "wim.hof@fontys.nl",
                    LocalDate.of(1995, 1, 19), 33
            );

            repository.saveAll(List.of(a, b));
        };
    }

}

