package day1108.run;

import day1108.service.Service;

public class Run {

	public static void main(String[] args) {
		//조립자 클래스를 객체화하고, 조립자가 조립해준 객체를 받아서 사용하는 일.
		Assembly ass=new Assembly();
		Service service=ass.getBean();
		
		for(String name:service.searchNames()) {
			System.out.println(name);
		}//end for

	}//main

}//class
