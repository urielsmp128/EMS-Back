package net.urielm.controller;

import lombok.AllArgsConstructor;
import net.urielm.dto.DepartmentDTO;
import net.urielm.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Add Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentCreated = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(departmentCreated, HttpStatus.CREATED);
    }

    //Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("id") Long departmentId){
        DepartmentDTO departmentDTO = departmentService.getDepartment(departmentId);
        return  ResponseEntity.ok(departmentDTO);
    }

    //Build Get All Departments REST API
    @GetMapping()
    public ResponseEntity <List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departmentDTOList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentDTOList);
    }

    //Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTOUpdated = this.departmentService.updateDepartment(departmentId, departmentDTO);
        return ResponseEntity.ok(departmentDTOUpdated);
    }

    //Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        this.departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully...");
    }
}
