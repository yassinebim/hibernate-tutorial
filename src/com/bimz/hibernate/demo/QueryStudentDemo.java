package com.bimz.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimz.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create SessionFactory
		
		SessionFactory factory = new Configuration()
				.configure()// by default the compiler look for "hibernate.cfg.xml "
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create Session
		
		Session session  = factory.getCurrentSession();
		
		try {
			
//			start transaction
			session.beginTransaction();
//			query
			List<Student>students = session.createQuery("from Student").getResultList();
			
			students.stream().forEach(System.out::println);
//			commit transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
