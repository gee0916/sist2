package day1110.sub;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseApplicationContext {
	
	public static void main(String[] args) {
		
		//1. �����������̳ʻ���
		ApplicationContext ac=new ClassPathXmlApplicationContext("day1110/sub/applicationContext.xml");
		//2. bean���
		Service service=ac.getBean(Service.class);
		System.out.println(service+"/"+service.getDao());
		//3. ����
		((ClassPathXmlApplicationContext)ac).close();
		
	}//main

}//class
