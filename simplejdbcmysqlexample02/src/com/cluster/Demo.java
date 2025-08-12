package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Caught Exception :" + e);
		}
	}

}
