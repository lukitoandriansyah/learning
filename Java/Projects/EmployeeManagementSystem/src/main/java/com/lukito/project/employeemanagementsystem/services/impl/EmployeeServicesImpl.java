package com.lukito.project.employeemanagementsystem.services.impl;

import com.lukito.project.employeemanagementsystem.model.Employee;
import com.lukito.project.employeemanagementsystem.services.EmployeeService;
import com.lukito.project.employeemanagementsystem.services.exception.ResourceNotFoundException;
import com.lukito.project.employeemanagementsystem.services.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
        else {
            throw new ResourceNotFoundException("Employee","id",id);
        }

    }
}
