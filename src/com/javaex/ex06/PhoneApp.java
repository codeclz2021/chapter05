package com.javaex.ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {
	//필드
	
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반	
	public static void main(String[] args) throws IOException {
		// Scanner 준비
		Scanner sc = new Scanner(System.in);

		// ArrayList 메모리에 올리기
		List<Person> pList = new ArrayList<Person>();

		// phoneDB.txt 접속
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		
		// 파일을 읽어서 리스트에 추가한다
		while (true) {
			// 한줄씩 읽는다.
			String line = br.readLine();
			if (line == null) { // 마지막 끝
				break;
			}

			// 마지막이 아니면 ,로 구분한다
			String[] dArray = line.split(",");
			String name = dArray[0];
			String hp = dArray[1];
			String company = dArray[2];

			// Person객체를 생성하고 값을 넣어준다
			Person p01 = new Person(name, hp, company);

			// *******리스트에 추가해준다*******
			pList.add(p01);
		}

		// 화면출력
		listPrint(pList);		
		/*
		for (int i = 0; i < pList.size(); i++) {
			System.out.println("이  름:" + pList.get(i).getName());
			System.out.println("핸드폰:" + pList.get(i).getHp());
			System.out.println("회  사:" + pList.get(i).getCompany());
			System.out.println("");
		}
		*/

		// 키보드로 값을 입력받는다.
		System.out.println("데이터를 입력하세요");
		String line = sc.nextLine();

		String[] dArray = line.split(",");
		String name = dArray[0];
		String hp = dArray[1];
		String company = dArray[2];

		// Person객체를 생성하고 값을 넣어준다
		Person p01 = new Person(name, hp, company);

		// *******리스트에 추가해준다*******
		pList.add(p01);

		// 화면출력
		listPrint(pList);	
		/*
		for (int i = 0; i < pList.size(); i++) {
			System.out.println("이름:" + pList.get(i).getName());
			System.out.println("핸드폰:" + pList.get(i).getHp());
			System.out.println("회사:" + pList.get(i).getCompany());
			System.out.println("");
		}
		*/

		// 파일저장
		Writer fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < pList.size(); i++) {
			/*
			String str = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
			*/
			String str = pList.get(i).info();
			bw.write(str);
			bw.newLine();
		}

		bw.close();
		br.close();

		sc.close();

	}
	
	//
	//전달받은 리스를 출력하는 메소드
	public static void listPrint(List<Person> personList) {
		for (int i = 0; i < personList.size(); i++) {
			System.out.println("이름:" + personList.get(i).getName());
			System.out.println("핸드폰:" + personList.get(i).getHp());
			System.out.println("회사:" + personList.get(i).getCompany());
			System.out.println("");
		}
		
	}
	

}
