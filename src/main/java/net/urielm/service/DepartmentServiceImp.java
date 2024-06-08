package net.urielm.service;

import lombok.AllArgsConstructor;
import net.urielm.dto.DepartmentDTO;
import net.urielm.entity.Department;
import net.urielm.exceptions.ResourceNotFoundException;
import net.urielm.mapper.DepartmentMapper;
import net.urielm.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DepartmentDTO getDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department with given id does not exists"));
        return DepartmentMapper.toDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(DepartmentMapper::toDepartmentDTO).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department with given id does not exists"));

        department.setDepartmentName(DepartmentMapper.toDepartment(departmentDTO).getDepartmentName());
        department.setDepartmentDescription(DepartmentMapper.toDepartment(departmentDTO).getDepartmentDescription());

        Department departmentUpdated = this.departmentRepository.save(department);
        return DepartmentMapper.toDepartmentDTO(departmentUpdated);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department with given id does not exists"));

        this.departmentRepository.deleteById(departmentId);
    }


}
