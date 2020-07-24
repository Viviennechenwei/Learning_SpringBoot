package com.learning.cache;

import com.learning.cache.bean.Employee;
import com.learning.cache.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    EmployeeService employeeService;
    @Test
    void contextLoads() {
        Employee employeeById = employeeService.getEmployeeById(3);
        System.out.println(employeeById);
    }

}
