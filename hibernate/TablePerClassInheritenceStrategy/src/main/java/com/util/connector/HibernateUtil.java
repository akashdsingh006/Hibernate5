package com.util.connector;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	static StandardServiceRegistry standardServiceRegistry;
	static SessionFactory sessionFactory;
	
	static {
		standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata= metadataSources.buildMetadata();
		sessionFactory = metadata.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory!=null) {
			return sessionFactory;
		}
		return null;
	}
}
