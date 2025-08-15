package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {
	public static void main(String[] args) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		
			try {
			
				Class .forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			System.out.println("Got Data Connection");
			st = con.createStatement();
			st.getResultSet();
			
			
			rs =st.executeQuery("SELECT * FROM TOPPER_TUTORIALS;");
			ResultSetMetaData rsmd = rs.getMetaData();
				
				
			System.out.println("DISPLAYING RESULTSET ALL COLUMNS");
				System.out.println();
				System.out.println("" + rsmd.getColumnCount());
				System.out.println("" + rsmd.getColumnLabel(2));
				System.out.println("" + rsmd.getColumnType(1));
				System.out.println("" + rsmd.getColumnTypeName(3));
				System.out.println();
		} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
