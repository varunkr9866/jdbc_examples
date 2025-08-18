package com.cluster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cluster.util.DButil;

public class Account {
		public void transfer(int sacc,int dacc,int amt) throws Exception {
			int daba1,saba1,danbal1,sanbal1;
			Connection con = null;
			PreparedStatement pst1 = null;
			PreparedStatement pst2 = null;
			ResultSet rs1 = null;
			ResultSet rs2 = null;
			
			try {
				con = DButil.getConnection();
				//start Transaction
				con.setAutoCommit(false);
				//operation1 select
				pst1 =con.prepareStatement("SELECT BAL FROM ACCOUNT WHERE ACC =?");
				pst1.setInt(1, sacc);
				rs1 =pst1.executeQuery();
				if (rs1.next()) 
				{
					saba1 = rs1.getInt(amt);
				} else 
				{
					throw new Exception();
				}
				if (saba1 >= amt) 
				{
					sanbal1 = saba1-amt;
				} else 
				{
					throw new Exception();
				}
				pst2 = con.prepareStatement("UPDATE ACCOUNT SET BAL = ? WHERE ACC = ?");
				pst2.setInt(1, sanbal1);
				pst2.setInt(2, sacc);
				pst2.executeUpdate();
				
				
				//op3 select
				pst1.setInt(1, dacc);
				rs2 = pst1.executeQuery();
				if (rs2.next()) 
				{
					daba1 = rs2.getInt(3);
				} else 
				{
					throw new Exception();
				}
				danbal1 = daba1+amt;
				
				//update
				pst2.setInt(1, danbal1);
				pst2.setInt(2, dacc);
				pst2.executeUpdate();
				con.commit();
				System.out.println("Transaction Completed");
			} catch (ClassNotFoundException | SQLException e) {
				con.rollback();
				e.printStackTrace();
			}
			
		}
}
