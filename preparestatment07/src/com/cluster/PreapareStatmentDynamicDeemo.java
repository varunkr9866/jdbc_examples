package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreapareStatmentDynamicDeemo {
		public static void main(String[] args) {
			Connection con = null;
			PreparedStatement prst1 = null;
			
			Scanner sc = new Scanner(System.in);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Loaded The Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				System.out.println("Connection Established");
				
				System.out.println("Give Id as Input :");
				String id = sc.next();
				System.out.println("Give Name As Input :");
				String name = sc.next();
				System.out.println("Give gender of the Student :");
				String gender = sc.next();
				

				prst1 = con.prepareStatement("INSERT INTO TOPPER_TUTORIALS (id,name,gender)VALUES(?,?,?)");
				prst1.setString(1, id);
				prst1.setString(2, name);
				prst1.setString(3, gender);
				int i = prst1.executeUpdate();
				
				if (i == 1) {
					System.out.println("Values Are Inserted");
				} else {
					System.out.println("Values Are Not Inserted ");
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if (con != null) {
					try {
						con.close();
						sc.close();
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}
}
