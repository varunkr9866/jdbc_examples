package com.cluster;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cluster.util.DButil;

public class FileToDatabase {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			sc = new Scanner(new File("hello.txt"));
			con = DButil.getConnection();
			System.out.println("Got Data Base Connection");
			st = con.createStatement();
			
			while (sc.hasNext()) {
				int id = sc.nextInt();
				String name = sc.next();
				int sal = sc.nextInt();
				st.addBatch("INSERT INTO EMP VALUES('"+id+"','"+name+"','"+sal+"')");
				
			}
			st.executeBatch();
		} catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
