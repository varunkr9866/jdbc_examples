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
				System.out.println("DISPLAYING RESULTSET ALL COLUMNS");
				while (rs.next()) {
					String id = (rs.getString(1)+"\t");
					String name = (rs.getString(2) + "\t");
					String gender = (rs.getString(3) +"\t");
					Date date = rs.getDate(4);
					System.out.println();
					System.out.print(id);
					System.out.print(name);
					System.out.print(gender);
					System.out.print(date);
					System.out.println();
				}
				
				//selecting THREE rows
				rs =st.executeQuery("SELECT STUDENT_ID,STUDENT_NAME,GENDER FROM TOPPER_TUTORIALS;");
				System.out.println("DISPLAYING RESULTSET THREE COLUMNS");
				while (rs.next()) {
					String id = (rs.getString(1)+"\t");
					String name = (rs.getString(2) + "\t");
					String gender = (rs.getString(3) +"\t");
					System.out.println();
					System.out.print(id);
					System.out.print(name);
					System.out.print(gender);
					System.out.println();
					
				}
				
				//selecting TWO rows
				rs =st.executeQuery("SELECT STUDENT_ID,STUDENT_NAME FROM TOPPER_TUTORIALS;");
				System.out.println("DISPLAYING RESULTSET TWO COLUMNS");
				while (rs.next()) {
					String id = (rs.getString(1)+"\t");
					String name = (rs.getString(2) + "\t");
					System.out.println();
					System.out.print(id);
					System.out.print(name);
					System.out.println();
				}
				
				//selecting ONE rows
				rs =st.executeQuery("SELECT STUDENT_ID FROM TOPPER_TUTORIALS;");
				System.out.println("DISPLAYING RESULTSET ONE COLUMNS");
				while (rs.next()) {
					String id = (rs.getString(1)+"\t");
					System.out.println();
					System.out.print(id);
					System.out.println();
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