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
		return runner -> readStudent(studentDao, 2);
	}

	private Student createStudent(StudentDao studentDao) {
		System.out.println("Creating student...");

		Student student = new Student("Light", "Yagami", "light.yagami@example.com");

		studentDao.save(student);

		System.out.println("Saving student information...");
		System.out.println("Saved! Generated id: " + student.getId());

		Student leslie = new Student("Leslie", "Andrews", "leslie.andrews@example.com");
		studentDao.save(leslie);
		System.out.println("Saved Leslie. Generated id: " + leslie.getId());

		return student;
	}

	private void readStudent(StudentDao studentDao, Integer id) {
		System.out.println("Retrieving student id " + id + "...");
		Student student = studentDao.findById(id);
		System.out.println("Found the student " + student);
	}
}
