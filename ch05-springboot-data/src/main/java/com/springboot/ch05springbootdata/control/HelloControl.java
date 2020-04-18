package com.springboot.ch05springbootdata.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloControl {

    @Autowired
    JdbcTemplate jdbcTemplate; //SpringBoot自动注入JdbcTemplate

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;//SpringBoot自动注入NamedParameterJdbcTemplate

    @GetMapping("/query")
    public List<Map<String, Object>> queryAllAccounts(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from accounts");
        return list;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
