package com.cluster;

public class ExecteDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally{
			if (condition) {
				
			}
		}

	}

}
