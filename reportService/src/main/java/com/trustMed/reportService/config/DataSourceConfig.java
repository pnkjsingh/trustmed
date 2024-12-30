package com.trustMed.reportService.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DataSourceConfig {

    // TrustMed DataSource
    @Bean(name = "trustmedDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.trustmed")
    public DataSource trustmedDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "trustmedEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean trustmedEntityManagerFactory(
            @Qualifier("trustmedDataSource") DataSource trustmedDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(trustmedDataSource);
        em.setPackagesToScan("com.trustMed.reportService.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    // QuizDB DataSource
    @Bean(name = "quizdbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.quizdb")
    public DataSource quizdbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "quizdbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean quizdbEntityManagerFactory(
            @Qualifier("quizdbDataSource") DataSource quizdbDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(quizdbDataSource);
        em.setPackagesToScan("com.trustMed.reportService.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        em.setJpaPropertyMap(properties);

        return em;
    }
}

/*
 * package com.trustMed.reportService.config;
 * 
 * import org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.boot.context.properties.ConfigurationProperties; import
 * org.springframework.boot.jdbc.DataSourceBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
 * 
 * import javax.sql.DataSource; import java.util.HashMap;
 * 
 * @Configuration public class DataSourceConfig {
 * 
 * // TrustMed DataSource
 * 
 * @Bean(name = "trustmedDataSource")
 * 
 * @ConfigurationProperties(prefix = "spring.datasource.trustmed") public
 * DataSource trustmedDataSource() { return DataSourceBuilder.create().build();
 * }
 * 
 * @Bean(name = "trustmedEntityManagerFactory") public
 * LocalContainerEntityManagerFactoryBean trustmedEntityManagerFactory(
 * 
 * @Qualifier("trustmedDataSource") DataSource trustmedDataSource) {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean();
 * em.setDataSource(trustmedDataSource);
 * em.setPackagesToScan("com.trustMed.reportService.entity");
 * em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
 * 
 * HashMap<String, Object> properties = new HashMap<>();
 * properties.put("hibernate.hbm2ddl.auto", "update");
 * properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 * em.setJpaPropertyMap(properties);
 * 
 * return em; }
 * 
 * // QuizDB DataSource
 * 
 * @Bean(name = "quizdbDataSource")
 * 
 * @ConfigurationProperties(prefix = "spring.datasource.quizdb") public
 * DataSource quizdbDataSource() { return DataSourceBuilder.create().build(); }
 * 
 * @Bean(name = "quizdbEntityManagerFactory") public
 * LocalContainerEntityManagerFactoryBean quizdbEntityManagerFactory(
 * 
 * @Qualifier("quizdbDataSource") DataSource quizdbDataSource) {
 * LocalContainerEntityManagerFactoryBean em = new
 * LocalContainerEntityManagerFactoryBean(); em.setDataSource(quizdbDataSource);
 * em.setPackagesToScan("com.trustMed.reportService.entity");
 * em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
 * 
 * HashMap<String, Object> properties = new HashMap<>();
 * properties.put("hibernate.hbm2ddl.auto", "update");
 * properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 * em.setJpaPropertyMap(properties);
 * 
 * return em; } }
 */