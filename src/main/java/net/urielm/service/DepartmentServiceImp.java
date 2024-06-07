package net.urielm.service;

import lombok.AllArgsConstructor;
import net.urielm.dto.DepartmentDTO;
import net.urielm.entity.Department;
import net.urielm.mapper.DepartmentMapper;
import net.urielm.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
    
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department departmentCreated = DepartmentMapper.toDepartment(departmentDTO);
        this.departmentRepository.save(departmentCreated);
        return DepartmentMapper.toDepartmentDTO(departmentCreated);
    }
}
