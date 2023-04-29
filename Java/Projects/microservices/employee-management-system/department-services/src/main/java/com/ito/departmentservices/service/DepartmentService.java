package com.ito.departmentservices.service;

import com.ito.departmentservices.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDEpartmentByCode(String departmentCode);
}
