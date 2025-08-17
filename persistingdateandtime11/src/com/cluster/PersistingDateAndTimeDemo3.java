package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cluster.util.DButil;

public class PersistingDateAndTimeDemo3 {
	private static void persistingSQLdate() throws ClassNotFoundException, SQLException {
		Connection con = DButil.getConnection();
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		String mysqlQuery = "INSERT INTO EMP_DOB VALUES(?,?,?)";
		PreparedStatement pst1 = con.prepareStatement(mysqlQuery);
		pst1.setInt(1, 03);
		pst1.setString(2, "RANA");
		pst1.setDate(3, sqlDate);
		pst1.execute();
	}
	private static void persistingSQLtimestamp() throws ClassNotFoundException, SQLException  {
		Connection con = DButil.getConnection();
		java.util.Date date = new java.util.Date();
		System.out.println(date);
		java.sql.Timestamp sqltimestamp = new java.sql.Timestamp(date.getTime());
		System.out.println(sqltimestamp);
		String mysqlQuery = "INSERT INTO EMP_DOB VALUES(?,?,?)";
		PreparedStatement pst2 = con.prepareStatement(mysqlQuery);
		pst2.setInt(1, 04);
		pst2.setString(2, "SRINU");
		pst2.setTimestamp(3,sqltimestamp);
		pst2.execute();
		
	}
	private static void retrevetimestamp() throws ClassNotFoundException, SQLException {
		Connection con = DButil.getConnection();
		String mysqlQuery = "SELECT * FROM EMP_DOB";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(mysqlQuery);
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getTimestamp(3));
		}
		
	}
	
		public static void main(String[] args) {
			try {
//				persistingSQLdate();
//				persistingSQLtimestamp();
				retrevetimestamp();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
}
