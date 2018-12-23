package com.bimz.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimz.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student st = new Student("yassine", "bimezzagh", "yassine.bimezzagh@gmail.com");
//			start transaction
			session.beginTransaction();
//			save student object 
			session.save(st);
//			commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
