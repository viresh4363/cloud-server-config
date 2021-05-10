package com.ms.departments.controller;

import com.ms.departments.entity.Department;
import com.ms.departments.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/{id}")
    public Optional<Department> findDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Entering into method findDepartmentById() =>");
        LOGGER.info("Fetching department details based on Department Id :"+departmentId);
        return departmentService.findDepartmentById(departmentId);
    }

    @PostMapping("/add")
    public Department addEmployee(@RequestBody Department department){
        LOGGER.info("Entering into method addEmployee() =>");
        LOGGER.info("Adding department object :"+department.toString());
        return departmentService.addDeparment(department);
    }
}
