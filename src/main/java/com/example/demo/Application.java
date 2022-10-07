package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController // to test endpoints // todo made for testing, can remove later?
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// restful endpoint to test with
	@GetMapping
	public List<Student> hello() {
		return List.of(new Student(
				1L,
				"Hans",
				"hans.sprengers@fontys.nl",
				LocalDate.of(1988, 10,19), 33)
		);
	}

}
