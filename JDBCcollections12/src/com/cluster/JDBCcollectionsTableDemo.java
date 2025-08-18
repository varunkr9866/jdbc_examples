package com.cluster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cluster.util.DButil;

public class JDBCcollectionsTableDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DButil.getConnection();
			System.out.println("Got The Connection");
			st = con.createStatement();
			String mysqlQuery = "SELECT * FROM EMPLOYEE WHERE EMP_ID ='102';";
			rs = st.executeQuery(mysqlQuery);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception Caught" + e);
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.close();
					st.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error In Closing The Resources" + e);
					e.printStackTrace();
				}
			}
		}
	}
}
