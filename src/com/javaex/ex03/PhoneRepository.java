package com.javaex.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {
	
	private List<Person> pList;
    
    //phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList() throws IOException {
		Reader fr = new FileReader("PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		pList = new ArrayList<Person>();
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

	//phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	private void saveInfo(List<Person> list) throws IOException {
		Writer fw = new FileWriter("PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<list.size();i++) {
   			bw.write(list.get(i).DBinfo());
   			bw.newLine();
   			}
		bw.close();
	}
	
	//기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드 
	public void addInfo(Person phoneVO) throws IOException {
		pList = new ArrayList<Person>(getList());
		pList.add(phoneVO);
		saveInfo(pList);
		
	}

	//선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) throws IOException {
		pList = new ArrayList<Person>(getList());
		pList.remove(num);
		saveInfo(pList);
		
	}
	

}
