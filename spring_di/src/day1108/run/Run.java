package day1108.run;

import day1108.service.Service;

public class Run {

	public static void main(String[] args) {
		//������ Ŭ������ ��üȭ�ϰ�, �����ڰ� �������� ��ü�� �޾Ƽ� ����ϴ� ��.
		Assembly ass=new Assembly();
		Service service=ass.getBean();
		
		for(String name:service.searchNames()) {
			System.out.println(name);
		}//end for

	}//main

}//class
