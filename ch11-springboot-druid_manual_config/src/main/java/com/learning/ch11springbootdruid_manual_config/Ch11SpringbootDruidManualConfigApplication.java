package com.learning.ch11springbootdruid_manual_config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.learning.ch11springbootdruid_manual_config.mapper"})
@SpringBootApplication
public class Ch11SpringbootDruidManualConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch11SpringbootDruidManualConfigApplication.class, args);
    }
}
