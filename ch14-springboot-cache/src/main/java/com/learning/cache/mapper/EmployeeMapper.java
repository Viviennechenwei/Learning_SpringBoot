package com.learning.cache.mapper;

import com.learning.cache.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper {

    @Insert("insert into employee(id, lastName, email,gender, d_id) value(#{id}, #{lastName},#{email}, #{gender}, #{dId})")
    public void insertEmp(Employee employee);

    @Update("update employee set lastName = #{lastName}, email=#{email},gender=#{gender} where id = #{id}")
    public void updateEmp(Employee employee);

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Delete("delete employee where id = #{id}")
    void deleteEmp(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByName(String lastName);
}
