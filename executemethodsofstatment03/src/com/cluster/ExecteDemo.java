package com.cluster;

import java.sql.Connection;
import java.sql.Date;
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
			 boolean a = st.execute("INSERT INTO TOPPER_TUTORIALS (STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE)VALUES('014','BHARGAVI','F','2016-12-31');");
			 boolean b = st.execute("UPDATE TOPPER_TUTORIALS SET STUDENT_NAME = 'RAMU' WHERE STUDENT_ID = '002';");
			 boolean c = st.execute("DELETE FROM TOPPER_TUTORIALS WHERE STUDENT_ID ='003';");
			 boolean d = st.execute("SELECT * FROM TOPPER_TUTORIALS;");
			 System.out.println("Value Of a Is:" + a );
			 System.out.println("Value Of b Is:" + b );
			 System.out.println("Value Of c Is:" + c );
			 System.out.println("Value Of d Is:" + d );
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