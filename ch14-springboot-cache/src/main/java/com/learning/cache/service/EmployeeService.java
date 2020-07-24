package com.learning.cache.service;

import com.learning.cache.bean.Employee;
import com.learning.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = {"emp"})
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法。
     * CacheManager管理多个Cache组件，对缓存的真正CRUD操作再Cache组件中，每一个缓存组件有自己唯一的名字；
     * 几个属性：
     * cacheNames/Value: 指定缓存组件的名字；
     * key: 缓存数据使用的key。默认是方法参数的值。
     * 编写SpELl指定，例如#id-参数id的值；#a0/#p0/#root.args[0]-第一个参数的值
     * keyGenerator: key的生成器，可以自己指定key的生成器的组件id。 key/keyGenerator二选以使用
     * cacheManager: 指定缓存管理器；或者cacheResoler指定获取解析器
     * condition: 指定符合条件的情况下才缓存
     * unless: 否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断.
     * 如：unless="#result==null"
     * sync: 是否使用异步
     * <p>
     * 原理：
     * 1. 自动配置类： CacheAutoConfiguration
     * 2. 缓存的配置类
     * 3. SimpleCacheConfiguration默认生效
     * 4. 给容器注册了一个CacheManager：ConcurrentMapCacheManager
     * 5. 可以获取和创建ConcurrentMapCache类型的缓存组件；它的作用是将数据保存再ConcurrentMap中
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = {"emp"}, condition = "#root.args[0]>1", keyGenerator = "myKeyGenerator")
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmployeeById(Integer id) {
        System.out.println("quering emp id: " + id);
        return employeeMapper.getEmpById(id);
    }


    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("update employee: " + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    //    @CacheEvict(cacheNames = {"emp"}, key="#id") //在不想删除Cache中所有数据时，如果要delete其他方法加入缓存的数据时，要保证key一致
    @CacheEvict(allEntries = true, beforeInvocation = true) //删除Cache中所有数据
//    @CacheEvict(cacheNames = {"emp"}, beforeInvocation = true) //方法之前清除缓存
    public void deleteEmp(Integer id) {
        System.out.println("delete employee : " + id);
        //employeeMapper.deleteEmp(id);
//        int i = 1000 / 0;
    }


    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName")
            },
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email")
            }
    )
    public Employee getEmpByName(String lastName) {
        System.out.println("get employee: " + lastName);
        return employeeMapper.getEmpByName(lastName);
    }

}


