package com.hibernate_demo.demo;

import com.hibernate_demo.demo.dao.StudentDao;
import com.hibernate_demo.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> createStudent(studentDao);
	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("Creating student...");

		Student student = new Student("Light", "Yagami", "light.yagami@example.com");

		studentDao.save(student);

		System.out.println("Saving student information...");
		System.out.println("Saved! Generated id: " + student.getId());
	}
}
