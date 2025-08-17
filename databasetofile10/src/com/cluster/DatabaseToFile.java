package com.cluster;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cluster.util.DButil;

public class DatabaseToFile {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		
		try {
			con = DButil.getConnection();
			st =con.createStatement();
			st.execute("SELECT * FROM EMP;");
			while
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
