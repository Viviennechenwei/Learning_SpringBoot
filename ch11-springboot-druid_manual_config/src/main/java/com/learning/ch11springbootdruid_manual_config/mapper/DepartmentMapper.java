package com.learning.ch11springbootdruid_manual_config.mapper;

import com.learning.ch11springbootdruid_manual_config.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;
//表明这是一个操作数据库的mapper
//有两种方式1. 每个mapper上都写@Mapper标记
//        2. 在主配置类上用@MapperScan(value = {"com.learning.ch11springbootdruid_manual_config.mapper"})统一标记
//@Mapper
public interface DepartmentMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")//返回数据表中，自动生成的id
    @Insert("insert into department(department_name) values( #{departmentName})")
    public int addDepar(Department department);

    @Delete("delete from department where id =1")
    public int deleteDepar();

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDepar();

    @Select("select * from department where Id = #{id}")
    public List<Department> selectDepar(Integer id );
}
