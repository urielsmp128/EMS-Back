package net.urielm.service;

import net.urielm.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmloyee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);
}
