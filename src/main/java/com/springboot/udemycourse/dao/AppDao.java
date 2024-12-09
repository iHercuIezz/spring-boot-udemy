package com.springboot.udemycourse.dao;

import com.springboot.udemycourse.entity.Instructor;
import com.springboot.udemycourse.entity.InstructorDetail;

public interface AppDao {

    Instructor findInstructorById(int id);

    void save(Instructor instructor);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailsById(int id);

    void deleteInstructorDetailById(int id);

}
