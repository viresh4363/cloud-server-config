package com.ms.employee.controller;

import com.ms.employee.dto.EmployeeDepartmentDetails;
import com.ms.employee.entity.Employee;
import com.ms.employee.serivce.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private  static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable ("id") Long employeeId){
        LOGGER.info("Entering into method getEmployeeById() =>");
        LOGGER.info("Employee Id :"+employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/department/{empId}")
    public EmployeeDepartmentDetails getEmployeeByDepartmentId(@PathVariable ("empId") Long employeeId){
        LOGGER.info("Entering into method getEmployeeByDepartmentId() =>");
        return employeeService.getEmployeeByDepartmentId(employeeId);
    }

   @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
