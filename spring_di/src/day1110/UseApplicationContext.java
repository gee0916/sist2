package day1110;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseApplicationContext {

	public static void main(String[] args) {

		//1. Spring Container ����
		ApplicationContext ac=new ClassPathXmlApplicationContext("day1110/applicationContext.xml");
		
		//2. Bean ���
		ProductService ps=ac.getBean(ProductService.class);
		System.out.println("������ ����������:"+ps.getpDAO());
		System.out.println("-----------------");
		
		//method������ ���Ե� ��ü
		ProductService2 ps2=ac.getBean(ProductService2.class);
		System.out.println("method ����������:"+ps2.getpDAO());
		
		//datatype injection
		DataTypeInjection dti=ac.getBean("dti",DataTypeInjection.class);
		System.out.println("���ڿ�: "+dti.getMsg());
		System.out.println("����: "+dti.getDay());
		System.out.println("-----------------");
		
		DataTypeInjection dti2=ac.getBean("dti2",DataTypeInjection.class);
		System.out.println("���ڿ�: "+dti2.getMsg());
		System.out.println("����: "+dti2.getDay());
		
		//3. Spring Container �ݱ�
		if(ac!=null) {
			((ClassPathXmlApplicationContext)ac).close();
		}//end if

	}//main

}//class
