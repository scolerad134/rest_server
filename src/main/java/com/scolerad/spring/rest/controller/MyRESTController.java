package com.scolerad.spring.rest.controller;


import com.scolerad.spring.rest.entity.Employee;
import com.scolerad.spring.rest.exception_handling.EmployeeIncorrectData;
import com.scolerad.spring.rest.exception_handling.NoSuchEmployeeException;
import com.scolerad.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");

        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        if (employeeService.getEmployeeById(id) == null)
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }
}















