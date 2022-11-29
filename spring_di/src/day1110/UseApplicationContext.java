package day1110;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseApplicationContext {

	public static void main(String[] args) {

		//1. Spring Container 생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day1110/applicationContext.xml");
		
		//2. Bean 얻기
		ProductService ps=ac.getBean(ProductService.class);
		System.out.println("생성자 의존성주입:"+ps.getpDAO());
		System.out.println("-----------------");
		
		//method의존성 주입된 객체
		ProductService2 ps2=ac.getBean(ProductService2.class);
		System.out.println("method 의존성주입:"+ps2.getpDAO());
		
		//datatype injection
		DataTypeInjection dti=ac.getBean("dti",DataTypeInjection.class);
		System.out.println("문자열: "+dti.getMsg());
		System.out.println("정수: "+dti.getDay());
		System.out.println("-----------------");
		
		DataTypeInjection dti2=ac.getBean("dti2",DataTypeInjection.class);
		System.out.println("문자열: "+dti2.getMsg());
		System.out.println("정수: "+dti2.getDay());
		
		//3. Spring Container 닫기
		if(ac!=null) {
			((ClassPathXmlApplicationContext)ac).close();
		}//end if

	}//main

}//class
