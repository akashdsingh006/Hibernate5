package com.util.connector;

import org.hibernate.Session;

import com.entity.objects.Person;
import com.entity.objects.Student;

public class ConnectionUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try(Session session=HibernateUtil.getSessionFactory().openSession()){
			 session.beginTransaction();
			 
			 Person person= new Person();
			 person.setPersonName("Akash");
			 
			 Student student=new Student();
			 student.setStudentName("Ramya");
			 student.setStudentAge(22);
			 
			 session.save(person);
			 session.save(student);
			 
			 
			 session.getTransaction().commit();
		 }catch(RuntimeException e) {
			 e.printStackTrace();
		 }
	}

}
