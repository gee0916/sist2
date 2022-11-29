package day1109.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day1108.service.Service;

/**
 * ������� �ս��� ����� �� �ִ� Spring DI�� ���
 * @author user
 */
public class UseSpringContainer {

	public static void main(String[] args) {

		//1. Spring Container ����
		ApplicationContext ac=new ClassPathXmlApplicationContext("day1109/run/applicationContext.xml");
		
		//2. Spring Container���� Service ��ü�� ���
		Service service=ac.getBean(Service.class);
		
		//3. �� ��ü�� ���
		for(String name:service.searchNames()) {
			System.out.println(name);
		}//end for
		
		//4. Spring Container �ݱ�
		((ClassPathXmlApplicationContext)ac).close();
		
	}//main

}//class
