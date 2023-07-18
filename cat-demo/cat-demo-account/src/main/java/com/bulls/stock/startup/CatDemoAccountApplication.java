package com.bulls.stock.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.bulls.stock"})
public class CatDemoAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatDemoAccountApplication.class, args);
    }

}
