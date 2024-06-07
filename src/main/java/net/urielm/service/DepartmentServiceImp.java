package net.urielm.service;

import net.urielm.dto.DepartmentDTO;
import net.urielm.entity.Department;
import net.urielm.mapper.DepartmentMapper;
import net.urielm.repository.DepartmentRepository;

public class DepartmentServiceImp implements DepartmentService {
    
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department departmentCreated = DepartmentMapper.toDepartment(departmentDTO);
        this.departmentRepository.save(departmentCreated);
        return DepartmentMapper.toDepartmentDTO(departmentCreated);
    }
}
