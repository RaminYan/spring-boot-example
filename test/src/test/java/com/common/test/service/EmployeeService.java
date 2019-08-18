package com.common.test.service;

import com.common.test.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();

}
