package com.springboot.ch04springbootlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch04SpringbootLoggingApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Ch04SpringbootLoggingApplication.class);
        SpringApplication.run(Ch04SpringbootLoggingApplication.class, args);
        logger.trace("this is trace log");
        logger.info("this is info log");
        logger.debug("this is debug log");
        logger.error("this is error log");
    }
}
