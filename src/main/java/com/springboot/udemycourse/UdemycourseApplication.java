package com.springboot.udemycourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.springboot.udemycourse", "com.springboot.util"}
)
public class UdemycourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemycourseApplication.class, args);
	}

}
