package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteAddBatch {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			 st = con.createStatement();
			 st.addBatch("INSERT INTO TOPPER_TUTORIALS (STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE)VALUES('011','RAMU','M','2016-12-31');");
			 st.addBatch("UPDATE TOPPER_TUTORIALS SET STUDENT_NAME = 'RAGU' WHERE STUDENT_ID = '009';");
			 st.addBatch("DELETE FROM TOPPER_TUTORIALS WHERE STUDENT_ID ='015';");
			 
			 int a[] = st.executeBatch();
			 System.out.println("Value of afor executing batch is:"+ a.length);
			 
			 for (int i = 0; i < a.length; i++) {
				System.out.println( a[i]);
			}
			 st.executeQuery("SELECT * FROM TOPPER_TUTORIALS;");
			 rs = st.getResultSet();
			 while (rs.next()) {
				String id =rs.getString("STUDENT_ID");
				String name =rs.getString("STUDENT_NAME");
				String gender =rs.getString("GENDER");
				Date date =rs.getDate("JOINING_DATE");
				System.out.println(id);
				System.out.println(name);
				System.out.println(gender);
				System.out.println(date);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
			finally{
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					if (st != null) {
						try {
							st.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						if (rs != null) {
							try {
								rs.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
	
				}
	
		}
	}			
}
