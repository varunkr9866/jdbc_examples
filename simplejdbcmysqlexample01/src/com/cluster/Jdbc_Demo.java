package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_Demo {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM TOPPER_TUTORIALS");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				Date date = rs.getDate(4);
				System.out.println("Id Of The Student Is:"+ id);
				System.out.println("Name Of The Student Is:"+ name);
				System.out.println("Gender Of The Student Is:"+ gender);
				System.out.println("Date Of Joining Is:"+ date + "\n");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception Caught: "+e);
		}
		
	}

}
