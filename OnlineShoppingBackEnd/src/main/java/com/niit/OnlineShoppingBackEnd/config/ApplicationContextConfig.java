package com.niit.OnlineShoppingBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.OnlineShoppingBackEnd.model.Product;

@Configuration
@ComponentScan("com.niit.ShoppingCartBackEnd.OnlineShoppingBackEnd.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Bean(name="datasource")
	public DataSource getH2Datasource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:~/target/ShoppingCartTest");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
	
	
	
	private Properties getHibernateProperties(){
		
		Properties p = new Properties();
		p.put("hibernate.show_sql", "true");
		//dialect--class used to choose the type of jar for the respective database
		//Supports to invoke that respective db related queries and its transactions
		p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource){
		//Create a class where we can 
		LocalSessionFactoryBuilder sessionbuilder = new LocalSessionFactoryBuilder(datasource);
		sessionbuilder.addProperties(getHibernateProperties());
		sessionbuilder.addAnnotatedClass(Product.class);
		return sessionbuilder.buildSessionFactory();
	}
	
}
