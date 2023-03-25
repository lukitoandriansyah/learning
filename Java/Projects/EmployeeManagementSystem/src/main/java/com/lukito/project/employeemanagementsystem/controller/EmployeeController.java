package com.lukito.project.employeemanagementsystem.controller;

import com.lukito.project.employeemanagementsystem.model.Employee;
import com.lukito.project.employeemanagementsystem.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //Build create employee API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //Build get all employee
    @GetMapping("/all")
    public List<Employee> getListAllEmployee() {
        return employeeService.getAllEmployee();
    }

    //Build get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<>(employeeService.getById(employeeId), HttpStatus.OK);
    }

    //Build Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee , @PathVariable("id") Long employeeId){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    }

    //Build Delete Employee

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Data with id " +  employeeId + " was deleted successfully", HttpStatus.OK);
    }





}
