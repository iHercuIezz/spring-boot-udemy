package com.springboot.udemycourse;

import com.springboot.udemycourse.dao.AppDao;
import com.springboot.udemycourse.entity.Course;
import com.springboot.udemycourse.entity.Instructor;
import com.springboot.udemycourse.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			//createInstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//findInstructorDetail(appDao);
			//deleteInstructorDetail(appDao);
			//createInstructorWithCourses(appDao);
			//findInstructorWithCourses(appDao);
			//findCoursesForInstructor(appDao);
			//findInstructorWithCoursesJoinFetch(appDao);
			//updateInstructor(appDao);
			//updateCourse(appDao);
			//deleteInstructor(appDao);
			deleteCourse(appDao);
		};
	}

	private void deleteCourse(AppDao appDao) {

		int id = 10;

		System.out.println("Deleting course id: " + id);

		appDao.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void updateCourse(AppDao appDao) {

		int id = 10;

		System.out.println("Finding course id: " + id);
		Course course = appDao.findCourseById(id);

		System.out.println("Updating course id: " + id);
		course.setTitle("Enjoy the simple things");

		appDao.update(course);

		System.out.println("Done!");

	}

	private void updateInstructor(AppDao appDao) {

		int id = 1;

		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Updating instructor id: " + id);
		instructor.setLastName("TEST");

		appDao.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {

		int id = 1;

		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("associated courses: " + instructor.getCourses());

		System.out.println("Done!");


	}

	private void findCoursesForInstructor(AppDao appDao) {

		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDao.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDao appDao) {

		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("The courses " + instructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor instructor = new Instructor("Bert", "Fransen", "bert.fransen@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/bertje", "Volleybal");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		appDao.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 3;
		System.out.println("Deleting instructor with id: " + id);

		appDao.deleteInstructorDetailById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id = 2;
		InstructorDetail instructorDetail = appDao.findInstructorDetailsById(id);

		System.out.println("InstructorDetail: " + instructorDetail);
		System.out.println("Associated instructor: " + instructorDetail.getInstructor());

		System.out.println("Done");

	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);

		appDao.deleteInstructorById(id);

		System.out.println("Done");
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
