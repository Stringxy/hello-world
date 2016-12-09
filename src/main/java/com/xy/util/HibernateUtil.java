package com.xy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		sessionFactory=config.buildSessionFactory(serviceregistry);
		
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
