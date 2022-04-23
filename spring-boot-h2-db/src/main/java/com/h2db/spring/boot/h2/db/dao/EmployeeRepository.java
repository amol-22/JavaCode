package com.h2db.spring.boot.h2.db.dao;

import com.h2db.spring.boot.h2.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDept(String dept);

}
