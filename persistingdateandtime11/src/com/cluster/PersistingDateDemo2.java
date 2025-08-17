package com.cluster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import com.cluster.util.DButil;

public class PersistingDateDemo2 {
		public static void main(String[] args) {
			Connection con = null;
			PreparedStatement pst = null;
			
			try {
				con = DButil.getConnection();
				String date = "31-12-2024";
				DateFormat dft = new SimpleDateFormat("dd-mm-yyyy");
				java.util.Date utilDate = dft.parse(date);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				String sqlQuery = "INSERT INTO EMP_DOB VALUES(?,?,?)";
				pst = con.prepareStatement(sqlQuery);
				pst.setInt(1, 02);
				pst.setString(2, "NAVVEN");
				pst.setDate(3, sqlDate);
				pst.execute();
				System.out.println("Done !!!!!!!!!!");
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
