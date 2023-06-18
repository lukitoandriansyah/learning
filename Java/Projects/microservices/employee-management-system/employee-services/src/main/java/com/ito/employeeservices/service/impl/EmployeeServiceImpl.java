package com.ito.employeeservices.service.impl;

import com.ito.employeeservices.dto.ApiResponseDto;
import com.ito.employeeservices.dto.DepartmentDto;
import com.ito.employeeservices.dto.EmployeeDto;
import com.ito.employeeservices.entity.Employee;
import com.ito.employeeservices.exception.EmailAlreadyExistException;
import com.ito.employeeservices.exception.ResourceNotFoundException;
import com.ito.employeeservices.mapper.AutoEmployeeMapper;
import com.ito.employeeservices.repository.EmployeeRepository;
import com.ito.employeeservices.service.ApiClient;
import com.ito.employeeservices.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;
    private WebClient webClient;
    private ApiClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> userOptional = employeeRepository.findByEmail(employeeDto.getEmail());
        if(userOptional.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist for Use");
        }

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        //Employee employee = modelMapper.map(employeeDto, Employee.class);
        //Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDto saveEmployeeDto = new EmployeeDto(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );
        //EmployeeDto saveEmployeeDto = modelMapper.map(saveEmployee, EmployeeDto.class);

        //return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(saveEmployee);
        return saveEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        /*ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/

        /*DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        //EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        //return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;


    }
}
