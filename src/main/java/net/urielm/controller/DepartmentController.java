package net.urielm.controller;

import lombok.AllArgsConstructor;
import net.urielm.dto.DepartmentDTO;
import net.urielm.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
