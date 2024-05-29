package net.urielm.service;

import lombok.AllArgsConstructor;
import net.urielm.dto.EmployeeDto;
import net.urielm.entity.Employee;
import net.urielm.exceptions.ResourceNotFoundException;
import net.urielm.mapper.EmployeeMapper;
import net.urielm.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        return EmployeeMapper.toEmployeeDto(employee);
    }

}
