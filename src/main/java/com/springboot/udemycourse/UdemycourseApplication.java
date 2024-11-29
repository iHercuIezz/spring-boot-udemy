package com.springboot.udemycourse;

import com.springboot.udemycourse.dao.StudentDao;
import com.springboot.udemycourse.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UdemycourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemycourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
			//createStudent(studentDao);
			createMultipleStudents(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudent(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating new student");
		Student student = new Student("Paul", "Doe", "paul.doe@random.com");

		System.out.println("Saving student");
		studentDao.save(student);

		System.out.println("Saved student: " + student.getId());
	}

	private void createMultipleStudents(StudentDao studentDao) {

		System.out.println("Creating 3 students");
		Student student1 = new Student("John", "Doe", "paul.doe@random.com");
		Student student2 = new Student("Mary", "Public", "mary.public@random.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita.applebum@random.com");

		System.out.println("Saving students");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);

	}

	private void readStudent(StudentDao studentDao) {

		System.out.println("Creating student");
		Student student = new Student("Daffy", "Duck", "daffyduck@random.com");

		System.out.println("Saving student");
		studentDao.save(student);

		int id = student.getId();
		System.out.println("Saved student id: " + id);

		System.out.println("Retrieving student with id: " + id);
		Student foundStudent = studentDao.findById(id);

		System.out.println("Found student:" + foundStudent);
	}

	private void queryForStudents(StudentDao studentDao) {

		List<Student> students = studentDao.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {

		List<Student> students = studentDao.findByLastName("Duck");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDao studentDao) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDao.findById(studentId);

		System.out.println("Updating student");
		student.setFirstName("John");

		studentDao.update(student);

		System.out.println("Updated student: " + student);
	}

	private void deleteStudent(StudentDao studentDao) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(studentId);
	}

	private void deleteAllStudent(StudentDao studentDao) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}
}
