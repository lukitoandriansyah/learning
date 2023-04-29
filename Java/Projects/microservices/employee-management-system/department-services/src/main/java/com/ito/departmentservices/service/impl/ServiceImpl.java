package com.ito.departmentservices.service.impl;

import com.ito.departmentservices.dto.DepartmentDto;
import com.ito.departmentservices.entity.Department;
import com.ito.departmentservices.mapper.AutoDepartmentMapper;
import com.ito.departmentservices.repository.DepartmentRepository;
import com.ito.departmentservices.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //Convert DepartmentDto to Department JPA entity
        /*Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );*/

        //Department department = modelMapper.map(departmentDto, Department.class);
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);

        /*DepartmentDto saveDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );*/
        //DepartmentDto saveDepartmentDto = modelMapper.map(saveDepartment, DepartmentDto.class);

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        /*DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );*/

        //DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
