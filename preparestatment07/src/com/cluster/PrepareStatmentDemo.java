package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStatmentDemo {
		public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prst1 = null;
		PreparedStatement prst2 = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Loaded The Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				System.out.println("Connection Established");
				prst1 = con.prepareStatement("INSERT INTO TOPPER_TUTORIALS VALUES(?,?,?)");
				
				prst1.setString(1, "015");
				prst1.setString(2, "'RANA'");
				prst1.setString(3, "M");
				
				
//				prst1 = con.prepareStatement("SELECT * FROM TOPPER_TUTORIALS");
//
//				prst1.setString(1, "015");
//				prst1.setString(2, "'RANA'");
//				prst1.setString(3, "M");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}