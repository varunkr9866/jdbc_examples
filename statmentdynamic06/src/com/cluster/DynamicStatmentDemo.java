package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class DynamicStatmentDemo {
	public static void main(String[] args) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
			try {
			
				Class .forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				System.out.println("Got Data Connection");
				st = con.createStatement();
				System.out.println("please Enter The id : ");

				String id = sc.next();
				System.out.println("please Enter The name :");
				String name = sc.next();		
				System.out.println("please Enter The gender :");
				String gender = sc.next();

				rs = st.getResultSet();
				int i = st.executeUpdate("INSERT INTO TOPPER_TUTORIALS VALUES('"+ id +"','"+ name +"','"+ gender +"')");
				if (i == 1) {
					System.out.println("Value of i is :"+ i);
				}
				else {
					System.out.println("No Changes Made");
				}
			
				} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
}
