package com.learning.ch12springbootspringdatajpa.controler;

import com.learning.ch12springbootspringdatajpa.entity.User;
import com.learning.ch12springbootspringdatajpa.reposity.UserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserReposity userReposity;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User u = new User();
        u.setId(id);
        Example<User> example = Example.of(u);
        Optional<User> one = userReposity.findOne(example);
        return one.get();
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userReposity.save(user);
        return save;
    }

    @GetMapping("/userGreaterThanId/{id}")
    public List<User> getUsersByIdGreaterThan(@PathVariable("id") Integer id){
        return userReposity.getUserByIdGreaterThan(id);
    }
}
