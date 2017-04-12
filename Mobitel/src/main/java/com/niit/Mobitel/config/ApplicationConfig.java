package com.niit.Mobitel.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Mobitel.dao.ProductDAO;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.niit.Mobitel")
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("Starting of the method getHibernateProporties");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/target/filter.db");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}

	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("Hibernate Properties Implementation");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		System.out.println("Starting of method getSessionFactory");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		System.out.println("Starting of the method getTransactionManager");
		HibernateTransactionManager trancastionManager = new HibernateTransactionManager();
		System.out.println("Tansaction Implementation");
		return trancastionManager;
	}
	
	@Autowired
	@Bean(name="ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory){
		
		return new ProductDAO(sessionFactory);
	}

}
