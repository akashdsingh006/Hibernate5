package com.hql.util;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import com.hql.entity.Person;

public class ConnectionUtil {

	public static void main(String[] args) {
		insertData();
		getAllPersonEntityV1();
		getAllPersonV2();
		getPersonEntityV2();
	}

	private static void insertData() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Person person1 = new Person();
			person1.setPersonName("Akash");
			person1.setPersonAge(25);
			person1.setDabeOfBirth(Date.valueOf(LocalDate.of(2000, 10, 12)));
			
			Person person2 = new Person();
			person2.setPersonName("Rony");
			person2.setPersonAge(28);
			person2.setDabeOfBirth(Date.valueOf(LocalDate.of(1997, 5, 23)));
			
			Person person3 = new Person();
			person3.setPersonName("Sana");
			person3.setPersonAge(24);
			person3.setDabeOfBirth(Date.valueOf(LocalDate.of(2000, 1, 15)));

			Person person4 = new Person();
			person4.setPersonName("Kabir");
			person4.setPersonAge(30);
			person4.setDabeOfBirth(Date.valueOf(LocalDate.of(1994, 8, 9)));

			session.persist(person1); session.persist(person2);
			session.persist(person3); session.persist(person4);
			session.getTransaction().commit();
		}

	}
	
	private static void getAllPersonEntityV1() {
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			List<Person> list= session.createNativeQuery("SELECT * from person_table", Person.class).list();
			list.forEach(System.out::println);
		}
	}
	
	private static void getAllPersonV2() {
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> list= session.createNativeQuery("SELECT per_id,per_name from person_table").addScalar("per_id",IntegerType.INSTANCE).addScalar("per_name").list();
			for(Object[] ob:list) {
				System.out.println(ob[0]+" - "+ob[1]);
			}
		}
	}
	
	private static void getPersonEntityV2() {
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			List<Person> list = session.createNativeQuery("Select per_id,per_name,dob,per_age from person_table").addEntity(Person.class).list ();
			list.forEach(System.out::println);
		}
	}
}
