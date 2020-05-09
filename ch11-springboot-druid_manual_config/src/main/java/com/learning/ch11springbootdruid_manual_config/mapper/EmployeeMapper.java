package com.learning.ch11springbootdruid_manual_config.mapper;

import com.learning.ch11springbootdruid_manual_config.bean.Employee;

import java.util.List;

//要用@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {
    void addEmp(Employee employee);
    Employee getEmpById(Integer id);

    List<Employee> getAllEmps();
}
