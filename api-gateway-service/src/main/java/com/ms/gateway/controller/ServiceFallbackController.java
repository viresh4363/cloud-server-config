package com.ms.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFallbackController {
    private static final String EMPLYOEE_SERVICE_FAILUER_MSG="Employee service is under maintaince";
    private static final String DEPARTMENT_SERVICE_FAILUER_MSG="Department service is under maintaince";
    private  static  final Logger LOGGER = LoggerFactory.getLogger(ServiceFallbackController.class);

    @GetMapping("employeeService")
    public String employeeServiceFailuer() {
        LOGGER.info("Employee service not working, returning failure response to client");
        return EMPLYOEE_SERVICE_FAILUER_MSG;
    }

    @GetMapping("departmentService")
    public String departmentServiceFailuer() {
        LOGGER.info("Deparment service not working, returning failure response to client");
        return DEPARTMENT_SERVICE_FAILUER_MSG;
    }
}
