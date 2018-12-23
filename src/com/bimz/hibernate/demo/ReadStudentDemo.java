package com.bimz.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimz.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create SessionFactory
		
		SessionFactory factory = new Configuration()
				.configure()// by default the compiler look for "hibernate.cfg.xml "
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create Session
		
		Session session  = factory.getCurrentSession();
		
		try {
			
//			create student object 
			Student st = new Student("h", "h", "h.h@gmail.com");
//			start transaction
			session.beginTransaction();
//			save student object 
			Integer id  = (Integer) session.save(st);
//			commit transaction
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student retrievedStudent = session.get(Student.class, id);
			session.getTransaction().commit();
			System.out.println(retrievedStudent);
		}finally {
			factory.close();
		}
	}

}
