package com.hibernate_demo.demo;

import com.hibernate_demo.demo.dao.StudentDao;
import com.hibernate_demo.demo.entity.Student;
import java.util.List;
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
		return runner -> {
			createStudent(studentDao);
			// readStudent(studentDao, 2);
			// queryStudents(studentDao);
			// queryStudentLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
		};
	}

	private Student createStudent(StudentDao studentDao) {
		System.out.println("Creating student...");

		Student student = new Student("Light", "Yagami", "light.yagami@example.com");

		studentDao.save(student);

		System.out.println("Saving student information...");
		System.out.println("Saved! Generated id: " + student.getId());

		return student;
	}

	private void readStudent(StudentDao studentDao, Integer id) {
		System.out.println("Retrieving student id " + id + "...");
		Student student = studentDao.findById(id);
		System.out.println("Found the student " + student);
	}

	private void queryStudents(StudentDao studentDao) {
		List<Student> students = studentDao.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryStudentLastName(StudentDao studentDao) {
		List<Student> students = studentDao.findByLastName("Andrews");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDao studentDao) {
		int id = 1;
		System.out.println("Student ID: " + id);
		Student student = studentDao.findById(id);
		if (student == null) {
			System.out.println("No student found with ID " + id);
			return;
		}

		System.out.println("Updating student name...");
		student.setFirstName("Dark");

		studentDao.update(student);
		System.out.println("Updated student information: " + student);
	}

	private void deleteStudent(StudentDao studentDao) {
		int id = 3;
		System.out.println("Delete ID: " + id);
		studentDao.delete(id);
	}
}
