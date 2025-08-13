package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecteDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			 st = con.createStatement();
			 st.execute("INSERT INTO TOPPER_TUTORIALS (STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE)VALUES('012','VARUN','M','2016-12-31');");
			 st.execute("UPDATE TOPPER_TUTORIALS SET STUDENT_NAME = 'AMULYA' WHERE STUDENT_ID = '001';");
			 st.execute("DELETE FROM TOPPER_TUTORIALS WHERE STUDENT_ID ='003';");
			 st.execute("SELECT * FROM TOPPER_TUTORIALS;");
			 rs = st.getResultSet();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
			finally{
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (st != null) {
						try {
							st.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (rs != null) {
							try {
								rs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
	
				}
	
			}
	}			
}