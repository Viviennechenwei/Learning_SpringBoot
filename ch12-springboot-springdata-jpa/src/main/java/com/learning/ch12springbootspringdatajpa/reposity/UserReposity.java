package com.learning.ch12springbootspringdatajpa.reposity;

import com.learning.ch12springbootspringdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
public interface UserReposity extends JpaRepository<User,Integer> {

    List<User> getUserByIdGreaterThan(Integer id);
}
