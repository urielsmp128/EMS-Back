package net.urielm.mapper;

import net.urielm.dto.DepartmentDTO;
import net.urielm.entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO  toDepartmentDTO(Department department){
        return new DepartmentDTO(department.getId(), department.getDepartmentName(), department.getDepartmentDescription());
    }

    public static Department toDepartment(DepartmentDTO departmentDTO){
        return new Department(departmentDTO.getId(), departmentDTO.getDepartmentName(), departmentDTO.getDepartmentDescription());
    }
}
