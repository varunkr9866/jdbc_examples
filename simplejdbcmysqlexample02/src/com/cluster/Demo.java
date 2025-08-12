package com.cluster;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql","root","Cluster");
			Statement st = con.createStatement();
			st.execute("INSERT INTO TOPPER_TUTORIALS (STUDENT_ID,STUDENT_NAME ,GENDER ,JOINING_DATE )VALUES('11','RAJ','M','2018-12-21')");
			st.execute("INSERT INTO TOPPER_TUTORIALS (STUDENT_ID,STUDENT_NAME ,GENDER ,JOINING_DATE )VALUES('12','RANI','F','2018-12-22')");
			ResultSet rs = st.executeQuery("SELECT * FROM TOPPER_TUTORIALS");
			while (rs.next()) {
				String id =rs.getString(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				Date date = rs.getDate(4);
				SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
				 String stringDate = formatter.format(date);
				System.out.println(id +"/t" + name +"/t" +gender +stringDate);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Caught Exception :" + e);
		}
	}

}
