package com.ito.employeeservices.service;

import com.ito.employeeservices.dto.ApiResponseDto;
import com.ito.employeeservices.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long id);
}
