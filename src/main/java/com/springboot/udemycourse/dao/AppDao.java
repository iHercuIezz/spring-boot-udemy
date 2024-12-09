package com.springboot.udemycourse.dao;

import com.springboot.udemycourse.entity.Instructor;

public interface AppDao {

    Instructor findInstructorById(int id);

    void save(Instructor instructor);

    void deleteInstructorById(int id);

}
