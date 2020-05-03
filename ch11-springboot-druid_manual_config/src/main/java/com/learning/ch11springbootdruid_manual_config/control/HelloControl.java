package com.learning.ch11springbootdruid_manual_config.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloControl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/query")
    public List<Map<String, Object>> queryAcct(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from accounts");
        return list;
    }
}
