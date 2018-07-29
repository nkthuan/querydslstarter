package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {App.class})
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);

        SeedData seedData = run.getBean(SeedData.class);
        seedData.seedData();
    }
}