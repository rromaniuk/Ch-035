package com.crsms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



//@EnableWebMvc is turned off for console debug only!!!
//@EnableWebMvc
@Configuration

@EnableTransactionManagement
@ComponentScan({ "com.crsms.*" })
@PropertySource(value = { "classpath:postgresql.properties"})
@Import({ SecurityConfig.class})

public class ApplicationContextConfig {

	@Autowired
	private Environment environment;

	 @Bean
	    @Autowired
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.crsms.domain" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getRequiredProperty("database.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("database.url"));
		dataSource.setUsername(environment
				.getRequiredProperty("database.username"));
		dataSource.setPassword(environment
				.getRequiredProperty("database.password"));
				return dataSource;
	}
		
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",
				environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.use_sql_comments",
				environment.getRequiredProperty("hibernate.use_sql_comments"));
		properties.put("hibernate.cache.use_second_level_cache", 
				environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
		properties.put("hibernate.cache.region.factory_class", 
				environment.getRequiredProperty("hibernate.cache.region.factory_class"));
		properties.put("hibernate.hbm2ddl.auto",
				environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.hbm2ddl.import_files",
				environment.getRequiredProperty("hibernate.hbm2ddl.import_files"));
		return properties;
	}
	
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}

//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
}
