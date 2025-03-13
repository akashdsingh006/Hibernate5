package com.hql.util;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hql.entity.Employee;

public class ConnectionUtil {

	public static void main(String[] args) {
		//insertDataIntoDatabase();
		findByEmployeeId();
		findByEmployeeName();
	}

	private static void insertDataIntoDatabase() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Employee employee1 = new Employee();
			employee1.setEmployeeName("Akash");
			employee1.setDateOfJoining(Date.valueOf(LocalDate.of(2021, 10, 04)));
			employee1.setEmployeeSalary(80302.00);

			Employee employee2 = new Employee();
			employee2.setEmployeeName("Ramya");
			employee2.setDateOfJoining(Date.valueOf(LocalDate.of(2020, 12, 9)));
			employee2.setEmployeeSalary(120572.00);

			Employee employee3 = new Employee();
			employee3.setEmployeeName("Rahul");
			employee3.setDateOfJoining(Date.valueOf(LocalDate.of(2024, 5, 18)));
			employee3.setEmployeeSalary(5200.00);

			session.persist(employee1);
			session.persist(employee2);
			session.persist(employee3);

			session.getTransaction().commit();
		}
	}

	private static void findByEmployeeId() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Query<Employee> query = session.createNamedQuery("findByEmployeeId", Employee.class);
			query.setParameter("empId", 6);
			
			Employee employee = query.uniqueResult();
			System.out.println(employee);
		}
	}
	
	private static void findByEmployeeName() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Query<Employee> query= session.createNamedQuery("findEmployeeByName");
			query.setParameter("empName", "Akash");
			List<Employee> list = query.list();
			for(Employee ob : list) {
				System.out.println(ob);
			}
		}
	}
	
}
