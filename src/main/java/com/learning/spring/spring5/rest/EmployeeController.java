package com.learning.spring.spring5.rest;

import com.learning.spring.spring5.model.Employee;
import com.learning.spring.spring5.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    List<Employee> getAllEmployees() {
      return employeeService.getAllEmployees();
    }

    @GetMapping("contract-employees")
    List<Employee> getAllContractEmployees() {
        return employeeService.getAllEmployees();
    }
}
