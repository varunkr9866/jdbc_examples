package com.cluster;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileToDatabase {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("hello.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
