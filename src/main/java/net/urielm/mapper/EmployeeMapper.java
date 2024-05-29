package net.urielm.mapper;

import net.urielm.dto.EmployeeDto;
import net.urielm.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    public static Employee toEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
    }
}
