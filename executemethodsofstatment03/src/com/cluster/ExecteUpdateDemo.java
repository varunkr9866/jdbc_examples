package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecteUpdateDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			st = con.createStatement();
			//executing executeUpdate program
			int a = st.executeUpdate(
					"INSERT INTO TOPPER_TUTORIALS(STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE)VALUES('011','RAJ','M','2016-12-23');");
			int b = st.executeUpdate("UPDATE TOPPER_TUTORIALS SET STUDENT_NAME = 'OMKAR' WHERE STUDENT_ID = '008';");
			int c = st.executeUpdate("DELETE FROM TOPPER_TUTORIALS WHERE STUDENT_ID = '005';");
			System.out.println("Value of a is:"+ a);
			System.out.println("Value of b is:" + b);
			System.out.println("Value of c is:" + c);
			st.executeQuery("SELECT * FROM TOPPER_TUTORIALS");
			rs = st.getResultSet();
			
			while (rs.next()) {
				String id =rs.getString("STUDENT_ID");
				String name =rs.getString("STUDENT_NAME");
				String gender =rs.getString("GENDER");
				Date date = rs.getDate("JOINING_DATE");
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(gender);
				System.out.println(date);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception Caught :" + e);
			e.printStackTrace();
		}
		finally {
			try {
				if (con != null) {
					con.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
