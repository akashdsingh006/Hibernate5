package com.util.connector;

import org.hibernate.Session;

import com.entity.objects.Army;
import com.entity.objects.Person;
import com.entity.objects.Student;

public class ConnectionUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try(Session session=HibernateUtil.getSessionFactory().openSession()){
			 session.beginTransaction();
			 
			 Person person1 = new Person();
			 person1.setPersonName("Akash");
			 Person person2 = new Person();
			 person2.setPersonName("Rajesh");
			 
			 Student student1 = new Student();
			 student1.setPersonName("Ramya");
			 student1.setStudentAddress("Bangalore");
			 student1.setStudentAge(24);
			 
			 Army army = new Army();
			 army.setPersonName("Golu");
			 army.setArmyPost("Faridkot");
			 army.setArmyBattalion("Sikh Battalion");
			 
			 session.persist(person1);
			 session.persist(person2);
			 session.persist(student1);
			 session.persist(army);
			 
			 session.getTransaction().commit();
		 }catch(RuntimeException e) {
			 e.printStackTrace();
		 }
		 
		 readDataFromDatabase(HibernateUtil.getSessionFactory().openSession());
	}

	private static void readDataFromDatabase(Session session) {
		Person person = session.find(Person.class, 3);
		if(person instanceof Person && !(person instanceof Student) && !(person instanceof Army)) {
			System.out.println(person);
		}
		else if((person instanceof Student)) {
			System.out.println((Student)person);
		}
		else if(person instanceof Person && (person instanceof Army)) {
			System.out.println((Army)person);
		}
	}

}
