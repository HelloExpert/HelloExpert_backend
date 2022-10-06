package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController // to test endpoints // todo remove?
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// restful endpoint to test with
	@GetMapping
	public List<String> hello() {
		return List.of("Hello", "World");
	}

}
