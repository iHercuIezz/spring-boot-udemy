package com.springboot.udemycourse.rest;

import com.springboot.udemycourse.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Imano", "Rijde"));
        students.add(new Student("Briana", "Rijde"));
        students.add(new Student("Brian", "Mortier"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {

        if ((studentId > students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }

        return students.get(studentId);
    }

}
