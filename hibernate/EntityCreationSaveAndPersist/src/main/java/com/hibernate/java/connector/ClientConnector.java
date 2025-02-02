package com.hibernate.java.connector;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.java.entity.Student;
import com.hibernate.java.util.HibernateUtil;

/*
 * The primary key (usually annotated with @Id) should not be set explicitly in the constructor when using persist.
	Hibernate relies on the primary key value to identify and manage entities during persistence.
	Let Hibernate handle primary key generation (e.g., auto-increment or other strategies).
	
	
	*persist: For new entities (transient state). Hibernate assigns the primary key during the actual database insert.
	*merge: For detached entities. Reattaches the entity and synchronizes it with the database.
	*
	*
	*With save(), you can set the primary key value explicitly before saving the entity, and Hibernate will use that value.
	With persist(), you should not set the primary key explicitly. Instead, let Hibernate assign it during insertion.
 */
public class ClientConnector {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		Student student=new Student(19,"Ganesh",  5173215697L);
		//session.save(student);
		//session.merge(student);
		//session.persist(student);
		
		session.saveOrUpdate(student);
		
		session.getTransaction().commit();
		

	}

}
