package com.hibernate.mappings.utils;

import java.util.List;

import org.hibernate.Session;

import com.hibernate.crud.entity.Address;
import com.hibernate.crud.entity.BankingDetails;
import com.hibernate.crud.entity.Employee;
import com.hibernate.crud.entity.School;
import com.hibernate.crud.entity.Student;
import com.hibernate.crud.entity.Teacher;

public class ConnectionUtil {

	public static void main(String args[]) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//insertDetailsOfEmployee(session);
		
		//getDetailsByBankingDetails(session);
		
//		insertData(session);
		
		//oneToManyExample(session);
		
		School school1=new School();
		school1.setSchoolName("DAV");
		school1.setPrincipalName("Himesh Thakur");
		Teacher teacher1=new Teacher();
		teacher1.setTeacherName("Rekha");
		teacher1.setTeacherAge(19);
		Teacher teacher2=new Teacher();
		teacher2.setTeacherName("Amitabh");
		teacher2.setTeacherAge(24);
		school1.setTeacher(List.of(teacher1,teacher2));
		
		School school2 = new School();
		school2.setSchoolName("Khalsa Model");
		school2.setPrincipalName("Diljit Singh");
		school2.setTeacher(List.of(teacher1));
		
		session.beginTransaction();
		session.save(teacher1);
		session.save(teacher2);
		session.save(school1);
		session.save(school2);
		
		session.getTransaction().commit();
		
	}

	private static void oneToManyExample(Session session) {
		Teacher teacher=new Teacher();
		teacher.setTeacherName("Gopal");
		teacher.setTeacherAge(35);
		
		Student student1=new Student();
		student1.setStudentName("Dharmendar");
		
		Student student2=new Student();
		student2.setStudentName("Bala");
		
		teacher.setStudents(List.of(student1,student2));
		
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
	}

	private static void insertData(Session session) {
		Employee employee= new Employee();
		employee.setEmployeeNAme("Raja");
		employee.setSalary(87500.0);
		
		BankingDetails bankingDetails=new BankingDetails();
		bankingDetails.setAccountNumber(99461649154L);
		bankingDetails.setBankName("SBI Bank");
		
		employee.setBankingDetails(bankingDetails);
		
		Address address1 = new Address();
		address1.setCity("Jaipur");
		address1.setState("RJ");
		address1.setCountry("India");
		address1.setEmployee(employee);
		
		Address address2 = new Address();
		address2.setCity("Chennai");
		address2.setState("TN");
		address2.setCountry("India");
		address2.setEmployee(employee);
		
		employee.setAddresses(List.of(address1,address2));
		
		session.beginTransaction();
		session.persist(employee);
		session.getTransaction().commit();
	}

	private static void insertDetailsOfEmployee(Session session) {
		Employee employee =new Employee();
		employee.setEmployeeNAme("Ganesh");
		employee.setSalary(70000.0);
		BankingDetails bankingDetails=new BankingDetails();
		bankingDetails.setAccountNumber(99461649154L);
		bankingDetails.setBankName("ICICI Bank");
		
		employee.setBankingDetails(bankingDetails);
		
		session.beginTransaction();
		
		Integer id=(Integer)session.save(employee);
		System.out.println(id);
		
		session.getTransaction().commit();
	}

	private static void getDetailsByBankingDetails(Session session) {
		//session.beginTransaction();
		
		BankingDetails bankingDetails = session.get(BankingDetails.class,2);
		System.out.println(bankingDetails);
		System.out.println(bankingDetails.getEmployee());
		
		session.close();
	}
}
