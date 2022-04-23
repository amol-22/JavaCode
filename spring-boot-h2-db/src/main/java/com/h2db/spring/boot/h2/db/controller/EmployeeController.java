package com.h2db.spring.boot.h2.db.controller;

import com.h2db.spring.boot.h2.db.dao.EmployeeRepository;
import com.h2db.spring.boot.h2.db.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        return "Employee saved..";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAll() {
        log.info("getAll");
        return repository.findAll();
    }

    @GetMapping("/getEmployee/{id}")
    public List<Employee> getEmployeesByDept(@PathVariable String dept) {
        log.info("getEmployeesByDept");
        return repository.findByDept(dept);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") long id) {
        try {
            repository.deleteById((int) id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}