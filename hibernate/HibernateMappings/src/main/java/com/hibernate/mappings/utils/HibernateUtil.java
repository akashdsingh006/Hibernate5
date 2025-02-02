package com.hibernate.mappings.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources= new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.buildMetadata();
			sessionFactory = metadata.buildSessionFactory();
		
		
	}
	
	static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
