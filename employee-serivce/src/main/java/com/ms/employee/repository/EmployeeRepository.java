package com.ms.employee.repository;

import com.ms.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
       Employee findByEmployeeId(Long employeeId);
}
