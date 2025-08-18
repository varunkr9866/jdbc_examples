package com.cluster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cluster.util.DButil;

public class JdbcCollectionsDemo {
		public static void main(String[] args) {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				con = DButil.getConnection();
				System.out.println("Got The Connection");
				st = con.createStatement();
				String mysqlQuery = "SELECT EMP_NAME FROM EMPLOYEE;";
				rs = st.executeQuery(mysqlQuery);
				List<String> listName = new ArrayList<>();
				while (rs.next()) 
				{
					listName.add(rs.getString("EMP_NAME"));
				}
				for (String strName : listName) {
					System.out.println(strName);
				}
				
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
