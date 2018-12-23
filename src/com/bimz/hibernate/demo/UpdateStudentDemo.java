package com.bimz.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimz.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			Student myStudent = session.get(Student.class, 1);
			
			myStudent.setLastName("BIM");
//			commit transaction
			session.getTransaction().commit();
			
			session  = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student p set firstName = 'YAS' where id = 1").executeUpdate();
			session.getTransaction().commit();

		}finally {
			factory.close();
		}
	}

}
