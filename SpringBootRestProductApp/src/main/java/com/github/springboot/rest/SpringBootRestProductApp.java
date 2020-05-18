/**
* Application - Manage Product (Read existing Product and Write new Product via REST API)
* SpringBootRestProductApp - Main Class for SpringBoot
*
* @author Ravi Balsuni - https://github.com/ravibalsuni/
*/

package com.github.springboot.rest;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@SpringBootApplication
public class SpringBootRestProductApp {
 
    private static final Logger logger = LoggerFactory.getLogger(SpringBootRestProductApp.class);   

    public static void main(String[] args) {
    	logger.info("Spring-Boot Rest Application starts here");
        SpringApplication.run(SpringBootRestProductApp.class, args);
        logger.info("Spring-Boot Rest Application ends here");
        logger.info("Waiting for REST Client to invoke get and post methods - getProducts/addProduct");
    }
}