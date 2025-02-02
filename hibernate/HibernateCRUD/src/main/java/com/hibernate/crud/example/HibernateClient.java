package com.hibernate.crud.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.crud.entity.Address;
import com.hibernate.crud.entity.Employee;

public class HibernateClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Insert
		Employee employee = new Employee();
		employee.setEmployeeId(4);
		employee.setEmployeeName("Rahul");
		employee.setEmployeeSalary(5000.00);
		employee.setEmployeeAge(17);
		
		Address address=new Address();
		address.setCity("Kolkata");
		address.setState("WB");
		address.setStreet("PLC Street");
		
		Address address2=new Address();
		address2.setCity("Moga");
		address2.setState("PB");
		address2.setStreet("Ram Tirath Road");
		
		employee.setAddressList(List.of(address,address2));
		session.beginTransaction();
		
		
		session.save(employee);
		
		
		//Read
		Query query = session.createQuery("from Employee"); //using entity name 
		List<Employee> employees=query.list();
		//System.out.println(employees);
		
		
		//Update
		Employee updateEmp = session.get(Employee.class, 2);
		//updateEmp.setEmployeeSalary(70000.00);
		
		//Delete
		//session.delete(updateEmp);
		
		
		session.getTransaction().commit();
		session.close();
	}

}
