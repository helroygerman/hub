package org.gaahoo.resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBase {
	

	public SessionFactory factory(Class<?> stu){
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(stu)
				.buildSessionFactory();
				return factory;
	}
	
	public Session session(SessionFactory factory){
		Session session=factory.getCurrentSession();
		return session;
	}
}
