package com.hibernate.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hibernate.entity.Employee;

public class ConnectionUtil {

	public static void main(String[] args) {
		
		//Inserting data in db
		
//		try(Session session = HibernateUtil.getSessionFactory().openSession()){
//			session.beginTransaction();
//			Employee employee = new Employee();
//			employee.setEmployeeName("Rony");	employee.setEmployeeSalary(5010.78);
//			employee.setEmployeeJoiningDate(Date.valueOf(LocalDate.of(2022, 2,1)));
//			//session.save(employee);
//			session.persist(employee);
//			session.getTransaction().commit();
//		}
		
		//getAllEmployees(HibernateUtil.getSessionFactory().openSession());
		//getEmployeeById(HibernateUtil.getSessionFactory());
		getEmployeeByIdAndName(HibernateUtil.getSessionFactory());
		getAllEmployeeNames(HibernateUtil.getSessionFactory());
		getEmployeeIdAndName(HibernateUtil.getSessionFactory());
		updateEmployeeData(HibernateUtil.getSessionFactory());
		
	}

	private static void getAllEmployees(Session session) {
		String query= "FROM Employee";
		Query<Employee> employees = session.createQuery(query, Employee.class);
		employees.list().stream().forEach(System.out::println);
	}

	private static void getEmployeeById(SessionFactory sessionFactory) {
		try(Session session = sessionFactory.openSession()){
			String query = "FROM Employee WHERE employeeId=?";
			Query<Employee> namedQuery = session.createQuery(query, Employee.class);
			namedQuery.setParameter(0, 1);
			
			Employee employee = namedQuery.uniqueResult();
			System.out.println(employee);
		}	
	}
	
	private static void getEmployeeByIdAndName(SessionFactory sessionFactory) {
		try(Session session = sessionFactory.openSession()){
			String query = "FROM Employee where employeeId=:empId AND employeeName=:empName";
			Query<Employee> employeeResult = session.createQuery(query, Employee.class);
			employeeResult.setParameter("empName", "Akash");
			employeeResult.setParameter("empId", 1);
			
			Employee employee = employeeResult.uniqueResult();
			System.out.println(employee);
		}
	}
	
	private static void getAllEmployeeNames(SessionFactory sessionFactory) {
		try(Session session = sessionFactory.openSession()){
			String query = "SELECT employeeName FROM Employee";
			Query<String> result =session.createQuery(query);
			List<String> list = result.list();
			System.out.println(list);
		}
	}
	
	private static void getEmployeeIdAndName(SessionFactory sessionFactory) {
		try(Session session = sessionFactory.openSession()){
			String query = "select employeeId,employeeName from Employee";
			Query res = session.createQuery(query);
			List<Object[]> list = res.list();
			for(Object ob[] :list) {
				System.out.println(ob[0]+" - "+ob[1]);
			}
		}
	}
	
	private static void updateEmployeeData(SessionFactory sessionFactory) {
		try(Session session = sessionFactory.openSession()){
			session.beginTransaction();
			String query = "UPDATE Employee set employeeName=:empName WHERE employeeId=:empId";
			Query createQuery = session.createQuery(query);
			createQuery.setParameter("empName", "Diljit");
			createQuery.setParameter("empId", 4);
			
			createQuery.executeUpdate();
			session.getTransaction().commit();
			
		}
	}

}
