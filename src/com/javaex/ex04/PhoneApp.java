package com.javaex.ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String line = br.readLine(); // null

			if (line == null) {
				break;
			}

			String[] dataArray = line.split(",");

			String name = dataArray[0];
			String hp = dataArray[1];
			String company = dataArray[2];

			System.out.println("이름: " + name);
			System.out.println("핸드폰: " + hp);
			System.out.println("회사: " + company);
			System.out.println("");
		}

		
		
		
		br.close();

	}

}
