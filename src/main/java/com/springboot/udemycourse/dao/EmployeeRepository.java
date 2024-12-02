package com.springboot.udemycourse.dao;

import com.springboot.udemycourse.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
