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
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			st = con.createStatement();
			rs = st.getResultSet();
			int a = st.executeUpdate(
					"INSERT INTO TOPPER_TUTORIALS(STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE)VALUES('011','RAJ','M','2016-12-23');");
			int b = st.executeUpdate("UPDATE TOPPER_TUTORIALS SET STUDENT_NAME = 'OMKAR' WHERE STUDENT_ID = '008';");
			int c = st.executeUpdate("DELETE FROM TOPPER_TUTORIALS WHERE STUDENT_ID = '005';");
			st.execute("SELECT * FROM TOPPER_TUTORIALS");
			
			while (rs.next()) {
				String id =rs.getString("EMPLOYEE_ID");
				String name =rs.getString("EMPLOYEE_NAME");
				String gender =rs.getString("GENDER");
				Date date = rs.getDate("JOINING_DATE");
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception Caught :" + e);
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
