package com.cluster;

public class ExecteUpdateDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Exception Caught :" + e);
			e.printStackTrace();
		}
	}

}
