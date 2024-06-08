package net.urielm.service;

import net.urielm.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartment(Long departmentId);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO);

    void deleteDepartment(Long departmentId);


}
