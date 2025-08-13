package com.cluster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecteDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			 st = con.createStatement();
			 st.execute("");
			 st.execute("");
			 st.execute("");
			 st.execute("");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally{
			if (condition) {
				
			}
		}

	}

}
