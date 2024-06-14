package net.urielm.service;

import lombok.AllArgsConstructor;
import net.urielm.dto.EmployeeDto;
import net.urielm.entity.Department;
import net.urielm.entity.Employee;
import net.urielm.exceptions.ResourceNotFoundException;
import net.urielm.mapper.EmployeeMapper;
import net.urielm.repository.DepartmentRepository;
import net.urielm.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Department department = this.departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(() ->
                new ResourceNotFoundException("Department with given id does not exists"));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return EmployeeMapper.toEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.toEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmloyee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with given id does not exists"));
        employee.setFirstName(employeeDto.getFirstName() != null ? employeeDto.getFirstName() : employee.getFirstName());
        employee.setLastName(employeeDto.getLastName() != null ? employeeDto.getLastName() : employee.getLastName());
        employee.setEmail(employeeDto.getEmail() != null ? employeeDto.getEmail() : employee.getEmail());
        Department department = this.departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(() ->
                new ResourceNotFoundException("Department with given id does not exists"));
        employee.setDepartment(department);
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with given id does not exists"));
        employeeRepository.deleteById(id);
    }


}
