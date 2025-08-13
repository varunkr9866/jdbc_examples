package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecteUpdateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
			Statement st = con.createStatement();
			int a =st.executeUpdate("INSERT INTO TOPPER_TUTORIALS(STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE)VALUES('013','VARUN','M','2016-12-23')");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception Caught :" + e);
			e.printStackTrace();
		}
	}

}
