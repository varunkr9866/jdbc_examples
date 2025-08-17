package com.cluster;

import java.sql.Connection;
import java.sql.SQLException;

import com.cluster.util.DButil;

public class PersistingDateAndTimeDemo3 {
		public static void main(String[] args) {
			Connection con = null;
			
			try {
				con = DButil.getConnection();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
