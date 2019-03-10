package com.learning.spring.spring5.service;

import com.learning.spring.spring5.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAllEmployees() {
        Employee e1 = new Employee("1", "Arif", "Akram");
        Employee e2 = new Employee("2", "Dan", "Sun");
        return Arrays.asList(e1, e2);
    }
}
