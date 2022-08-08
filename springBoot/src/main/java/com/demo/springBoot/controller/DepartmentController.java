package com.demo.springBoot.controller;

import com.demo.springBoot.entity.DepartmentInfo;
import com.demo.springBoot.error.DepartmentNotFoundException;
//import com.demo.springBoot.repository.DepartmentRepository;
//import com.demo.springBoot.service.DepartmentService;
import com.demo.springBoot.service.DepartmentServiceClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceClass departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public DepartmentInfo saveDepartment(@Valid @RequestBody DepartmentInfo department){
        LOGGER.info("Inside Save Department of Department Controller");
        return departmentService.saveDepartment(department);
    }


    @GetMapping("/departments")
    public List<DepartmentInfo> fetchDepartmentList(){
        LOGGER.info("Inside Fetch Department of Department Controller");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public DepartmentInfo fetchDepartmentById(@PathVariable("id") int DepartmentId ) throws DepartmentNotFoundException {
        LOGGER.info("Inside Fetch Department by ID of Department Controller");
        return departmentService.fetchDepartmentById(DepartmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") int DepartmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside Delete Department by ID of Department Controller");
        departmentService.deleteDepartmentById(DepartmentId );
        return "Department deleted!!";
    }

    @PutMapping("/departments/{id}")
    public DepartmentInfo updateDepartment(@PathVariable("id") int DepartmentId, @RequestBody DepartmentInfo department){
        LOGGER.info("Inside Update Department of Department Controller");
        return departmentService.updateDepartment(DepartmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public DepartmentInfo fetchDepartmentByName(@PathVariable("name") String DepartmentName ) throws DepartmentNotFoundException {
        LOGGER.info("Inside Fetch Department by Name of Department Controller");
        return departmentService.fetchDepartmentByName(DepartmentName);
    }

}
