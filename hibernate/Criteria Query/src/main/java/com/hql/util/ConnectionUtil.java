 package com.hql.util;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.hql.dto.StudentVO;
import com.hql.entity.Student;

public class ConnectionUtil {

	public static void main(String[] args) {
		//insertData();
		criteriaQuery1();
		criteriaGetOneValue();
		criteriaGetOMultipleValue();
		criteriaGetMultipleValuesUsingTuple();
		criteriaGetMultipleFiledsInVO();
		criteriaParametersUse();
	}

	private static void insertData() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Student student1 = new Student();
			student1.setStudentName("Akash");
			student1.setStudentMarks(68.0);
			student1.setStudentRank(3);
			
			Student student2 = new Student();
			student2.setStudentName("Priya");
			student2.setStudentMarks(89.35);
			student2.setStudentRank(5);
			
			Student student3 = new Student();
			student3.setStudentName("Neha");
			student3.setStudentMarks(96.00);
			student3.setStudentRank(3);
			
			session.persist(student1);
			session.persist(student2);
			session.persist(student3);
			session.getTransaction().commit();
		}

	}
	
	private static void criteriaQuery1() {
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			Root<Student> root = query.from(Student.class);
			
			query.select(root);
			query.where(builder.equal(root.get("studentRank"), 3));
			session.createQuery(query).list().forEach(System.out::println);
		}
	}
	
	private static void criteriaGetOneValue() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> criteriaQuery= builder.createQuery(String.class);
			Root<Student> root = criteriaQuery.from(Student.class);
			criteriaQuery.select(root.get("studentName"));
			
			session.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
		}
	}
	
	private static void criteriaGetOMultipleValue() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
			Root<Student> root = criteriaQuery.from(Student.class);
			
			Path<Object> idPath = root.get("studentId");
			Path<Object> namePath = root.get("studentName");
			Path<Object> rankPath = root.get("studentRank");
			
			//Approach - 1
			//criteriaQuery.select(builder.array(idPath, namePath, rankPath));
			
			//Approach - 2
			criteriaQuery.multiselect(idPath, namePath, rankPath);
			List<Object[]> resultList = session.createQuery(criteriaQuery).getResultList();
			resultList.stream().forEach(obj -> System.out.println(obj[0]+" " + obj[1]+" "+ obj[2]));
		}
	}
	
	private static void criteriaGetMultipleValuesUsingTuple() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Tuple> query = criteriaBuilder.createQuery(Tuple.class);
			Root<Student> root = query.from(Student.class);
			
			Path<Object> idPath = root.get("studentId");
			Path<Object> namePath = root.get("studentName");
			query.multiselect(idPath, namePath);
			
			List<Tuple> resultList = session.createQuery(query).getResultList();
			for(Tuple res: resultList) {
				System.out.println((Integer)res.get(idPath) +" - " +(String)res.get(namePath));
			}
		}
	}
	
	private static void criteriaGetMultipleFiledsInVO() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<StudentVO> query = builder.createQuery(StudentVO.class);
			Root<Student> root = query.from(Student.class);
			
			Path<Object> studentName = root.get("studentName");
			Path<Object> marksPath = root.get("studentMarks");
			Path<Object> rankPath = root.get("studentRank");
			query.select(builder.construct(StudentVO.class, studentName,marksPath,rankPath));
			
			session.createQuery(query).getResultList().
			stream().sorted(Comparator.comparing(StudentVO::getStudentMarks).reversed()).forEach(System.out::println);
			
		}
	}
	
	private static void criteriaParametersUse() {
		String student = "Priya";
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			ParameterExpression<String> parameter = builder.parameter(String.class, "name");
			
			Root<Student> root = query.from(Student.class);
			query.select(root);
			query.where(builder.equal( root.get("studentName"), parameter));
			
			session.createQuery(query).setParameter("name", student).list().forEach(System.out::println);
			
		}
	}
}
