package com.cluster;


public class TransactionDemo1 {
	public static void main(String[] args)  {
		Account acc =  new Account();
		try {
			acc.transfer(11,33,5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End Of The Main Program");
	}
}
