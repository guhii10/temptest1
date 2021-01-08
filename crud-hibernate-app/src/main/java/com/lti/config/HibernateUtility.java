package com.lti.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import com.lti.entities.Student;

public class HibernateUtility {
	
	static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			
			Configuration cfg = new Configuration();
			Properties settings = new Properties();
			
			settings.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
			settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
			settings.put(Environment.USER, "nikil");
			settings.put(Environment.PASS, "nikilgo");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
			settings.put(Environment.SHOW_SQL, true);
			settings.put(Environment.HBM2DDL_AUTO, "update");
			
			cfg.setProperties(settings);
			cfg.addAnnotatedClass(Student.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			
		}
		return sessionFactory;
	}

}
