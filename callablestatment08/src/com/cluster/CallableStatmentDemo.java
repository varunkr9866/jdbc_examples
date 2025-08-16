package com.cluster;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatmentDemo {
		public static void main(String[] args) {
			Connection con = null;
			CallableStatement cst1 = null;
			CallableStatement cst2 = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				cst1 = con.prepareCall("{CALL PROC1(?)}");
				cst1.setString(1, "015");
				cst1.setInt(2, 98);
				int P = cst1.executeUpdate();
				System.out.println("Value Of P is :" + P);
				
				cst2 = con.prepareCall("{CALL PROC2 (?,?,?)}");
				cst2.setString(1, "016");
				cst2.registerOutParameter(2,Types.INTEGER);
				cst2.registerOutParameter(3,Types.INTEGER);
				int Q = cst2.executeUpdate();
				int t = cst2.getInt(2);
				int a = cst2.getInt(3);
				System.out.println("Value Of Q is :" + Q);
				System.out.println("Value Of t is :" + t);
				System.out.println("Value Of a is :" + a);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
