package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

		public static void main(String[] args) {
			Connection con =null;
			Statement st = null;
			ResultSet rs = null;
			try {
				Class .forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
				System.out.println("Got Data Connection");
				st = con.createStatement();
				st.getResultSet();
				
				//selecting all rows
				rs =st.executeQuery("SELECT * FROM TOPPER_TUTORIALS;");
				System.out.println("DISPLAYING RESULTSET");
				while (rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2) ;
					String gender = rs.getString(3) ;
					Date date = rs.getDate(4);
					
					System.out.println(id);
					System.out.println(name);
					System.out.println(gender);
					System.out.println(date);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
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