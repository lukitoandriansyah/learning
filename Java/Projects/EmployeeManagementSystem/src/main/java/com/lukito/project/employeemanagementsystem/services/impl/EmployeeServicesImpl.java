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

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            employee.setId(optionalEmployee.get().getId());
            if(employee.getFirstName()!=null){
                employee.setFirstName(employee.getFirstName());
            }else {
                employee.setFirstName(optionalEmployee.get().getFirstName());
            }
            if(employee.getLastName()!=null){
                employee.setLastName(employee.getLastName());
            }else {
                employee.setLastName(optionalEmployee.get().getLastName());
            }
            if(employee.getEmail()!=null){
                employee.setEmail(employee.getEmail());
            }else {
                employee.setEmail(optionalEmployee.get().getEmail());
            }

            return employeeRepository.save(employee);
        }
        else {
         throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional <Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }


}
