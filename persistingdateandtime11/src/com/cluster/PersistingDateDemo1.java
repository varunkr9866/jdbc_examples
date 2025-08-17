package com.cluster;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cluster.util.DButil;

public class PersistingDateDemo1 {
		public static void main(String[] args) {
			Connection con = null;
			Statement st = null;
			
			try {
				con = DButil.getConnection();
				String sqlQuery = "INSERT INTO EMP_DOB VALUES(01,'RAMU',STR_TO_DATE('25-12-2024', '%d-%m-%Y'))";
				st = con.createStatement();
				st.execute(sqlQuery);
				System.out.println("Done !!!!!!");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
