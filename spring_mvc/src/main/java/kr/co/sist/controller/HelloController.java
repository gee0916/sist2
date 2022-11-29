package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//DispatcherServlet�� ��û�� ���� URL�� ó���ϱ�����
//HandlerMapper�� �����Ͽ� ��û�� ó���� �� �ִ� Controller�� ã�� ���� ��Ų��.
//�̶� HandlerMapper�� ���� Ŭ���� �� @Controller annotation�� ����Ǿ��ִ�
//Ŭ������ �˻��Ѵ�.
@Controller
public class HelloController {

	//*method�ϳ��� ��û �ϳ��� ó��
	//��û�� ó���ϴ� method�� ��û URL�� ���� ��Ű�� ���ؼ�
	//@RequestMapping annotation��G�Ѵ�.
	//@RequestMapping(value="����URI", method=��û���)
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public String helloWork() {
		
		System.out.println("hello.do�� ��û�� ������");
		//���ϵǴ� ���ڿ��� ViewResolver�� �޾Ƽ� /WEB-INF/views�� JSP���Ϸ�
		//�����ϴ� �� ã��, �����ϸ� �⺻ forword�� �̵�
		//ViewResolver�� ���ϵǴ� ���ڿ��� �տ� (prefix) /WEB-INF/views/�� ���̰�
		//�ڿ� (suffix).jsp�� �ٿ��� ã�´�. : ������ servlet-context.xml�� �������.
		
		return "hello"; 
		
	}//helloWork
	
	
}
