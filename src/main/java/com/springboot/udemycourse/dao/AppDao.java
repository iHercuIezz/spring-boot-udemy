package com.springboot.udemycourse.dao;

import com.springboot.udemycourse.entity.Course;
import com.springboot.udemycourse.entity.Instructor;
import com.springboot.udemycourse.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    Instructor findInstructorById(int id);

    void save(Instructor instructor);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailsById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);
}
