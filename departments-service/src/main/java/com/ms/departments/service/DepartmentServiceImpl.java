package com.ms.departments.service;

import com.ms.departments.entity.Department;
import com.ms.departments.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    public Optional<Department> findDepartmentById(Long departmentId) {
        LOGGER.info("Inside method findDepartmentById(Long departmentId) in service DepartmentServiceImpl =>");
        //return departmentRepository.findDepartmentById(departmentId);
        return  departmentRepository.findById(departmentId);
    }

    public Department addDeparment(Department department) {
        LOGGER.info("Inside method addDeparment(Department department) in service DepartmentServiceImpl =>");
        return departmentRepository.save(department);
    }
}
