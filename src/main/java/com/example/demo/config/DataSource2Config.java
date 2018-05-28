package com.example.demo.config;

import java.util.HashMap;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
 
@Configuration
// Load to Environment
// (@see resources/datasource-cfg.properties).
@PropertySources({ @PropertySource("classpath:datasource-cfg.properties") })
public class DataSource2Config {
 
    @Autowired
    private Environment env; // Contains Properties Load by @PropertySources
 
    @Bean
    public DataSource ds2Datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.2"));
        dataSource.setUrl(env.getProperty("spring.datasource.url.2"));
        dataSource.setUsername(env.getProperty("spring.datasource.username.2"));
        dataSource.setPassword(env.getProperty("spring.datasource.password.2"));
 
        return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean ds2EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ds2Datasource());
 
        // Scan Entities in Package:
        em.setPackagesToScan(new String[] { Constants.PACKAGE_ENTITIES_2 });
 
        em.setPersistenceUnitName(Constants.JPA_UNIT_NAME_2);
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
 
        HashMap<String, Object> properties = new HashMap();
        // JPA & Hibernate
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.2"));
        properties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql.2"));
 
        // Solved Error: PostGres createClob() is not yet implemented.
        // PostGres Only.
        // properties.put("hibernate.temp.use_jdbc_metadata_defaults",  false);
 
        em.setJpaPropertyMap(properties);
        em.afterPropertiesSet();
        return em;
    }
 
    @Bean
    public PlatformTransactionManager ds2TransactionManager() {
 
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(ds2EntityManager().getObject());
        return transactionManager;
    }
 
}