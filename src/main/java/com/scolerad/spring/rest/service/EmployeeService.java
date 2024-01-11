package com.scolerad.spring.rest.service;

import com.scolerad.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);

    public void deleteEmployee(int id);
}
