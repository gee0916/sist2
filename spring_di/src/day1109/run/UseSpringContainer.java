package day1109.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day1108.service.Service;

/**
 * 약결합을 손쉽게 사용할 수 있는 Spring DI의 사용
 * @author user
 */
public class UseSpringContainer {

	public static void main(String[] args) {

		//1. Spring Container 생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day1109/run/applicationContext.xml");
		
		//2. Spring Container에서 Service 객체를 얻기
		Service service=ac.getBean(Service.class);
		
		//3. 얻어낸 객체를 사용
		for(String name:service.searchNames()) {
			System.out.println(name);
		}//end for
		
		//4. Spring Container 닫기
		((ClassPathXmlApplicationContext)ac).close();
		
	}//main

}//class
