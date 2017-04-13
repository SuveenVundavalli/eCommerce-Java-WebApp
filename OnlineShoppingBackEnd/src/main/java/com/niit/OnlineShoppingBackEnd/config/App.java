package com.niit.OnlineShoppingBackEnd.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContextConfig con = new ApplicationContextConfig();
        DataSource ds =  con.getH2Datasource();
        SessionFactory sf =  con.getSessionFactory(ds);
        System.out.println("Method ends here");
        
    }
}
