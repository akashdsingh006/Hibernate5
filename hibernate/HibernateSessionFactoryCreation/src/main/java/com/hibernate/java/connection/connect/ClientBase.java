package com.hibernate.java.connection.connect;

import org.hibernate.Session;

import com.hibernate.java.util.HibernateUtil;

public class ClientBase {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String SQL="SELECT tablename\r\n"
				+ "FROM pg_catalog.pg_tables\r\n"
				+ "WHERE schemaname = 'public';\r\n";
		String singleResult =(String) session.createNativeQuery(SQL).getSingleResult();
		
		System.out.println(singleResult);
	}

}
