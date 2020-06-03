package com.javaex.ex02;

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

//import com.javaex.ex01.Person;

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;

	public PhoneManager() throws IOException {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		pList = getList();
	}

	// 시작준비 (시작화면 출려과 리스트 가져온다)
	public void showTitle() {
		System.out.println("*******************************************");
    	System.out.println("*             전화번호 관리 프로그램                      *");
    	System.out.println("*******************************************");
    	
	}

	// 메뉴 출력과 입력을 받는다.
	public int showMenu() {
		System.out.println("1.리스트        2.등록       3.삭제       4.검색        5.종료");
       	System.out.println("-------------------------------------------");
       	System.out.print(">메뉴번호:");
		return sc.nextInt();

	}

	// 1.리스트선택시
	public void showList() {
		
		System.out.println("<1.리스트>");
   		for(int i=0;i<pList.size();i++) {
    		System.out.print(i+1 + ".");
   			pList.get(i).showList();
   		}
   		System.out.println("");
	}

	// 2.등록선택시
	public void showAdd() {
		sc.nextLine();
		System.out.println("<2.등록>");
   		System.out.print(">이름: ");
   		String name = sc.nextLine();
   		System.out.print(">휴대전화: ");
   		String hp = sc.nextLine();
   		System.out.print(">회사전화: ");
   		String company = sc.nextLine();
   		pList.add(new Person(name, hp, company));
   		System.out.println("[등록되었습니다.]");

	}

	// 3.삭제선택시
	public void showRemove() {
		System.out.println("<3.삭제>");
   		System.out.print(">번호: ");
   		int delList = sc.nextInt();
    	pList.remove(delList-1);

	}

	// 4.검색선택시
	public void showSearch() {
		sc.nextLine();
		System.out.println("<4.검색>");
   		System.out.print(">이름: ");
   		String srch = sc.nextLine();
   		for(int i=0;i<pList.size();i++) {
   			if((pList.get(i).getName()).contains(srch)) {
   				pList.get(i).showList();
   			}
   		}

	}

	// 5.종료시
	public void showEnd() throws IOException {
		System.out.println("*******************************************");
    	System.out.println("*                  감사합니다                            *");
    	System.out.println("*******************************************");
    	saveList();

	}
	
	
	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {
		
		System.out.println("[다시 입력해 주세요.]");

	}
	
	
	// 파일을 읽어 리스트에 담아 전달한다.
	private List<Person> getList() throws IOException {
		Reader fr = new FileReader("PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		String name, hp, company;
		while(true) {
			String str = br.readLine();
			if(str == null) {
				break;
			}
			String[] info = str.split(",");
			name = info[0];
			hp = info[1];
			company = info[2];
			pList.add(new Person(name, hp, company));
		}
		br.close();
		return pList;
	}

	// 리스트를 파일에 저장한다.
	private void saveList() throws IOException {
		Writer fw = new FileWriter("PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<pList.size();i++) {
			System.out.println(pList.get(i).DBinfo());
   			bw.write(pList.get(i).DBinfo());
   			bw.newLine();
   			}
		bw.close();
	}

//	// 전체 리스트를 출력한다
//	private void printList() {
//		printList("");// 아래 메소드에 키워드값을 비워서 호출
//	}
//
//	// 키워드로 검색한 리스트를 출력한다
//	private void printList(String keyword) {
//		
//	}
	
}
