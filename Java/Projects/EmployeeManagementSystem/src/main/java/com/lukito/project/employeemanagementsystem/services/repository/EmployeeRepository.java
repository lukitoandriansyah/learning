package com.lukito.project.employeemanagementsystem.services.repository;

import com.lukito.project.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
