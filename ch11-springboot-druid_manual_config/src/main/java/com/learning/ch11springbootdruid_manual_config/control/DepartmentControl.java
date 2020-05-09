package com.learning.ch11springbootdruid_manual_config.control;

import com.learning.ch11springbootdruid_manual_config.bean.Department;
import com.learning.ch11springbootdruid_manual_config.bean.Employee;
import com.learning.ch11springbootdruid_manual_config.mapper.DepartmentMapper;
import com.learning.ch11springbootdruid_manual_config.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentControl {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public List<Department> queryDept(@PathVariable("id") Integer id){
        return departmentMapper.selectDepar(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.addDepar(department);
        return department;
    }


    @GetMapping("/emp/{id}")
    public Employee queryEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/queryEmp")
    public List<Employee> queryAllEmps(){
        return employeeMapper.getAllEmps();
    }
    @GetMapping("/emp")
    public Employee insertEmp(Employee employee){
        employeeMapper.addEmp(employee);
        return employee;
    }
}
