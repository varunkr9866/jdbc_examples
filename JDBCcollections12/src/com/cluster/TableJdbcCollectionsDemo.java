package com.cluster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cluster.to.Employee;
import com.cluster.util.DButil;

public class TableJdbcCollectionsDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DButil.getConnection();
			System.out.println("Got The Connection");
			st = con.createStatement();
			String mysqlQuery = "SELECT * FROM EMPLOYEE;";
			rs = st.executeQuery(mysqlQuery);
			List<Employee> listEmp = new ArrayList<Employee>();
			
			while(rs.next()) 
			{
				Employee emp = new Employee();
				emp.setEmployeeid(rs.getInt("EMP_ID"));
				emp.setName(rs.getString("EMP_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhone(rs.getInt("PHONE"));
				listEmp.add(emp);
			}
			for (Employee emp : listEmp) 
			{
				System.out.println("Employee ID is:" + emp.getEmployeeid());
				System.out.println("Employee NAME is:" + emp.getName());
				System.out.println("Employee EMAIL is:" + emp.getEmail());
				System.out.println("Employee PHONE is:" + emp.getPhone());
				System.out.println();
				
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
