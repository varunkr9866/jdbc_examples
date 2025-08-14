package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSetDemo {

	public static void main(String[] args) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class .forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
			System.out.println("Got Data Connection");
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//selecting all rows
			
			rs =st.executeQuery("SELECT * FROM TOPPER_TUTORIALS;");
			System.out.println("DISPLAYING RESULTSET ALL COLUMNS");
			while (rs.next()) {
				System.out.println((rs.getString("STUDENT_ID") +"\t"));
				System.out.println((rs.getString("STUDENT_NAME") + "\t"));
				System.out.println((rs.getString("GENDER") +"\t"));
				System.out.println(rs.getDate("JOINING_DATE"));
			} 
				
				
				rs.absolute(5);
				rs.updateString(2,"DHARANI");
				rs.updateRow();
				
				
				rs.absolute(2);
				rs.deleteRow();
				
				
				rs.moveToInsertRow();
				rs.updateString(1, "015");
				rs.updateString("STUDENT_NAME", "DHAMU");
				rs.updateString("GENDER", "M");
				rs.insertRow();
				rs.previous();
				rs.first();
				
				
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
