package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetScrolableDemo {

	public static void main(String[] args) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class .forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
			System.out.println("Got Data Connection");
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//selecting all rows
			
			rs =st.executeQuery("SELECT * FROM TOPPER_TUTORIALS;");
			System.out.println("DISPLAYING RESULTSET ALL COLUMNS");
			while (rs.next()) {
				String id = (rs.getString("STUDENT_ID") +"\t");
				String name = (rs.getString("STUDENT_NAME") + "\t");
				String gender = (rs.getString("GENDER") +"\t");
				Date date = rs.getDate("JOINING_DATE");
				
				//Cursor moves to exact 10th row
				rs.absolute(10);
				System.out.print(id);
				System.out.print(name);
				System.out.print(gender);
				System.out.print(date);
				System.out.println();
				
				//previous of present cursor
				rs.previous();
				System.out.print(id);
				System.out.print(name);
				System.out.print(gender);
				System.out.print(date);
				System.out.println();
				
				//3rd previous of present cursor
				rs.relative(-3);
				System.out.print(id);
				System.out.print(name);
				System.out.print(gender);
				System.out.print(date);
				System.out.println();
				
				//cursor moves to first row
				rs.first();
				System.out.print(id);
				System.out.print(name);
				System.out.print(gender);
				System.out.print(date);
				System.out.println();
				
				//cursor moves to last row
				rs.last();
				System.out.print(id);
				System.out.print(name);
				System.out.print(gender);
				System.out.print(date);
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
