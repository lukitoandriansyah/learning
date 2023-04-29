package com.ito.employeeservices.service.impl;

import com.ito.employeeservices.dto.EmployeeDto;
import com.ito.employeeservices.entity.Employee;
import com.ito.employeeservices.exception.EmailAlreadyExistException;
import com.ito.employeeservices.exception.ResourceNotFoundException;
import com.ito.employeeservices.mapper.AutoEmployeeMapper;
import com.ito.employeeservices.repository.EmployeeRepository;
import com.ito.employeeservices.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> userOptional = employeeRepository.findByEmail(employeeDto.getEmail());
        if(userOptional.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist for Use");
        }

        /*Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );*/

        //Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee saveEmployee = employeeRepository.save(employee);
        /*EmployeeDto saveEmployeeDto = new EmployeeDto(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail()
        );*/
        //EmployeeDto saveEmployeeDto = modelMapper.map(saveEmployee, EmployeeDto.class);

        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(saveEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        /*EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );*/

        //EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

    }
}
