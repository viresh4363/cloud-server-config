package com.ms.employee.serivce;

import com.ms.employee.dto.EmployeeDepartmentDetails;
import com.ms.employee.entity.Department;
import com.ms.employee.entity.Employee;
import com.ms.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl {

    private  static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee getEmployeeById(Long employeeId){
        LOGGER.info("Inside getEmployeeById in serivce EmployeeServiceImpl =>");
        LOGGER.debug("Fetching employee details based on employee id : "+employeeId);
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public EmployeeDepartmentDetails getEmployeeByDepartmentId(Long employeeId){
        LOGGER.info("Inside getEmployeeByDepartmentId in serivce EmployeeServiceImpl =>");
        EmployeeDepartmentDetails employeeDepartmentDetails = new EmployeeDepartmentDetails();
        LOGGER.debug("Fetching employee details based on employee id : "+employeeId);
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        LOGGER.debug("Employee details  : "+employee.toString());
        LOGGER.debug("Fetching department details based on department id : "+employee.getDepartmentId());
        Department department = restTemplate.getForObject("http://departments-service/department/"+employee.getDepartmentId(), Department.class);
        LOGGER.debug("Department details  : "+department.toString());
        employeeDepartmentDetails.setEmployee(employee);
        employeeDepartmentDetails.setDepartment(department);
        return employeeDepartmentDetails;
    }

    public Employee addEmployee(Employee employee) {
        LOGGER.info("Employee Id Is: " +employee.toString());
        return employeeRepository.save(employee);
    }
}
