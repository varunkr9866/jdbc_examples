package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
			Statement st = con.createStatement();
			ResultSet rs = st.getResultSet();
			rs.next();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Caught Exception :" + e);
		}
	}

}
