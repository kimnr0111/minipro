package com.javaex.ex01;

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

    public static void main(String[] args) throws IOException {
    	
    	Reader fr = new FileReader("PhoneDB.txt");
    	BufferedReader br = new BufferedReader(fr);
		
    	List<Person> pList = new ArrayList<Person>();
    	
    	while(true) {
    		String str = br.readLine();
    		if(str == null) {
    			break;
    		}
    		String[] info = str.split(",");
    		String name = info[0];
			String hp = info[1];
			String company = info[2];
			pList.add(new Person(name, hp, company));
			System.out.println("이름:" + name);
			System.out.println("휴대폰:" + hp);
			System.out.println("회사:" + company);
			System.out.println("");
    		
    	}
    	br.close();
    	
    	Writer fw = new FileWriter("PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
    	int menu;
    	boolean menuflag = true;

    	System.out.println("*******************************************");
    	System.out.println("*             전화번호 관리 프로그램                      *");
    	System.out.println("*******************************************");
    	
    	
    	try {
    		Scanner sc = new Scanner(System.in);
        	while(menuflag) {
           		System.out.println("1.리스트        2.등록       3.삭제       4.검색        5.종료");
               	System.out.println("-------------------------------------------");
               	System.out.print(">메뉴번호:");               	
           		menu = sc.nextInt();
           		switch(menu) {
               	case 1:
               		System.out.println("<1.리스트>");
               		for(int i=0;i<pList.size();i++) {
                		System.out.print(i+1 + ".");
               			pList.get(i).showList();
               		}
               		break;
               	case 2:
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
               		break;
               	case 3:
               		sc.nextLine();
               		System.out.println("<3.삭제>");
               		System.out.print(">번호: ");
               		int delList = sc.nextInt();
                	pList.remove(delList-1);
               		break;
               	case 4:
               		sc.nextLine();
               		System.out.println("<4.검색>");
               		System.out.print(">이름: ");
               		String srch = sc.nextLine();
               		for(int i=0;i<pList.size();i++) {
               			if((pList.get(i).getName()).contains(srch)) {
               				pList.get(i).showList();
               			}
               		}
               		break;
                case 5:
                   	menuflag = false;
               		break;
               	default:
               		System.out.println("[다시 입력해 주세요.]");
               		break;
               	}
                     	
           	}
        	sc.close();
    	} catch(Exception e) {
    		System.out.println("에러");
    	}

   		for(int i=0;i<pList.size();i++) {
   			bw.write(pList.get(i).DBinfo());
   			bw.newLine();
   			}
   		bw.close();
    	
    	
    	System.out.println("*******************************************");
    	System.out.println("*                  감사합니다                            *");
    	System.out.println("*******************************************");
    	
    }

}