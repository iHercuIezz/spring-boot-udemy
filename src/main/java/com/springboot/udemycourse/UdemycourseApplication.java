package com.springboot.udemycourse;

import com.springboot.udemycourse.dao.AppDao;
import com.springboot.udemycourse.entity.Instructor;
import com.springboot.udemycourse.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UdemycourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemycourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			//createInstructor(appDao);
			//findInstructor(appDao);
			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);

		appDao.deleteInstructorById(id);

		System.out.println("Deleted instructor");
	}

	private void findInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Found instructor: " + instructor);
		System.out.println("with instructor details: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {

		/*
		Instructor instructor = new Instructor("Imano", "Rijde", "ixrijde@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/herculezz", "Fitness");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructorDetail);
		appDao.save(instructor);
		System.out.println("Saved!");

		*/
		Instructor instructor = new Instructor("Briana", "Rijde", "briana@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/briana", "Tekenen");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructorDetail);
		appDao.save(instructor);
		System.out.println("Saved!");
	}

}
