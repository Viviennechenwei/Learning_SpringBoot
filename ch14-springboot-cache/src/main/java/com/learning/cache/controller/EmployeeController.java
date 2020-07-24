package com.learning.cache.controller;

import com.learning.cache.bean.Employee;
import com.learning.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id")Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/updateEmp")
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
         employeeService.deleteEmp(id);
        return "Success";
    }


    @GetMapping("/emp/empName/{lastName}")
    public Employee getEmpByName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByName(lastName);
    }
}
