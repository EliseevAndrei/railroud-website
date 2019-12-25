package com.eliseev.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
/*@Import(MapperConfiguration.class)
@ComponentScans(value = {
        @ComponentScan("com.eliseev.app.repository"),
        @ComponentScan("com.eliseev.app.dto")
})*/
@ImportResource(locations = {"classpath:dispatcher-servlet-context.xml",
        "classpath:jpa-configuration.xml"})
public class DaoTestConfigITConfig {




    /*@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.eliseev.app.models");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

    *//*@Bean DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        dataSource.setUrl("jdbc:mysql://localhost:3306/railway?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false");
        return dataSource;
    }*//*

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        *//*properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.dialect.storage_engine", "InnoDB");*//*
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        *//*properties.setProperty("hibernate.show_sql", "true");*//*
        properties.setProperty("hibernate.hbm2ddl.import_files", "data.sql");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }*/



}