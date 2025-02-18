//package com.practice.demo.config;
//
//
//import javax.sql.DataSource;
//
////import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import jakarta.persistence.EntityManagerFactory;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.example.repositoryB", 
//						entityManagerFactoryRef = "entityManagerFactoryB",
//						transactionManagerRef = "transactionManagerB")
//public class DatabaseBConfig {
//	
//	@Primary
//	@Bean(name = "dataSourceB")
//	@ConfigurationProperties(prefix = "database-b-datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
//	
//	@Primary
//	@Bean(name = "entityManagerFactoryB")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, 
//			@Qualifier("dataSourceB") DataSource dataSource) {
//				return builder
//						.dataSource(dataSource)
//						.packages("com.example.modelB")
//						.persistenceUnit("DatabaseB")
//						.build();
//	}
//	
//	@Primary
//	@Bean(name = "transactionManagerB")
//	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactoryB")
//			EntityManagerFactory managerFactory) {
//		return new JpaTransactionManager(managerFactory);
//	}
//}
