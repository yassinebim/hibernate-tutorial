package com.bimz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestJdbc {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		
		try {
			Connection con= DriverManager.getConnection(url, user,pass);
			System.out.println("Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
