package com.lukito.project.employeemanagementsystem.services;

import com.lukito.project.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);
}
