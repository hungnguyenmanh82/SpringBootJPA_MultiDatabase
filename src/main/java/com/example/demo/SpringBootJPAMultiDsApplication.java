package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
 
@SpringBootApplication
 
/**
 * Vì Springboot auto config cho JPA trong trường hợp có 1 database để config (hay 1 FactorySession)
 * Trường hợp nhiều database thì ta phải config bằng tay => vì thế phải bỏ tính năng auto config
 * 
 *  https://o7planning.org/en/11653/using-multiple-datasources-with-spring-boot-and-jpa
 */
@EnableAutoConfiguration(exclude = { //
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })
 
public class SpringBootJPAMultiDsApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJPAMultiDsApplication.class, args);
    }
     
}
