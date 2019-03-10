package com.learning.spring.spring5.rest;

import com.learning.spring.spring5.model.Employee;
import com.learning.spring.spring5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    // @Autowired annotation is required here
    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;
    @Autowired
    @Qualifier("contractEmployeeServiceImpl")
    EmployeeService contractEmployeeService;

    // Above is the demonstration of field injection. Below is the demonstration of constructor injection. Only one method of injection
    // can be used.
    /*@Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService,
                              @Qualifier("contractEmployeeServiceImpl") EmployeeService contractEmployeeService) {
        this.employeeService = employeeService;
        this.contractEmployeeService = contractEmployeeService;
    }*/

    @GetMapping("employees")
    List<Employee> getAllEmployees() {
      return employeeService.getAllEmployees();
    }

    @GetMapping("contract-employees")
    List<Employee> getAllContractEmployees() {
        return contractEmployeeService.getAllEmployees();
    }
}
