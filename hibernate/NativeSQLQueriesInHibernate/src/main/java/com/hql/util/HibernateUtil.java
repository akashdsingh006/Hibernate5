package com.hql.util;

import java.util.Objects;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		if(sessionFactory == null) {
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.buildMetadata();
			sessionFactory = metadata.buildSessionFactory();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		if(Objects.nonNull(sessionFactory)) {
			return sessionFactory;
		}return null;
	}
}
