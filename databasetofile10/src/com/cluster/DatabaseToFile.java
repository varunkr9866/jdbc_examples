package com.cluster;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cluster.util.DButil;

public class DatabaseToFile {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("cluster.txt"));
			con = DButil.getConnection();
			st =con.createStatement();
			rs = st.executeQuery("SELECT * FROM EMP");
			while (rs.next()) {
				pw.write(rs.getInt(1)+"\t");
				pw.write(rs.getString(2)+"\t");
				pw.write(rs.getInt(3)+"\n");
				pw.flush();
			}
			System.out.println("Finished Writing To File");
		} catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
