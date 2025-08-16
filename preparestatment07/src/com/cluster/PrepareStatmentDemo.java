package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStatmentDemo {
		public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prst1 = null;
		PreparedStatement prst2 = null;
		PreparedStatement prst3 = null;
		ResultSet rs = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Loaded The Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				System.out.println("Connection Established");
				prst1 = con.prepareStatement("INSERT INTO TOPPER_TUTORIALS (STUDENT_ID,STUDENT_NAME,GENDER,JOINING_DATE) VALUES(?,?,?,?);");
				
				prst1.setString(1, "015");
				prst1.setString(2, "'RANA'");
				prst1.setString(3, "M");
				prst1.setDate(4, null);
				prst1.executeUpdate();
				
				prst1.setString(1, "016");
				prst1.setString(2, "'NEELA'");
				prst1.setString(3, "M");
				prst1.setDate(4, null);
				prst1.executeUpdate();
				
				prst1.setString(1, "017");
				prst1.setString(2, "'KANTA'");
				prst1.setString(3, "M");
				prst1.setDate(4, null);
				prst1.executeUpdate();
				
				prst2 = con.prepareStatement("UPDATE TOPPER_TUTORIALS SET STUDENT_NAME =? WHERE STUDENT_ID = ?");
				prst2.setString(1, "RADHA");
				prst2.setString(2, "010");
				prst2.executeUpdate();
				
				prst2.setString(1, "KRISHNA");
				prst2.setString(2, "005");
				prst2.executeUpdate();
				
				prst2.setString(1, "MURARI");
				prst2.setString(2, "003");
				prst2.executeUpdate();
				
				
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}