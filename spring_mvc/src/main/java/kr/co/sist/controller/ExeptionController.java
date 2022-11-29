package kr.co.sist.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ExeptionController {

	//method�� ȣ��ɶ� �߻��ϴ� ���ܴ� DispatcherServlet�� ��´�. => ���ܹ߻���
	//���� �������� �����ڰ� ������ �� ����.
	@RequestMapping(value="/day1108/exception1.do", method=GET )
	public String exception1(Model model) throws ClassNotFoundException {
		
		String loadClass="java.lang.String";
		
		if(new Random().nextBoolean()) {
			loadClass="java.lang.String1";
		}//end if
		
		Class.forName(loadClass);
		model.addAttribute("msg", "Ŭ�����ε� ����");
		
		return "day1108/success";
	}//exception
	
	/**
	 * �߻��� ���ܸ� DispatcherServlet�� �ƴ� �����ڰ� ������ method���� ó��.
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/day1108/exception2.do", method=GET )
	public String exception2(Model model) throws IOException {
		
		String path="E:/dev/workspace_spring/spring_mvc/src/main/java/kr/co/sist/controller/ExeptionController.java";
		
		if(new Random().nextBoolean()) {
			path+="1";// ���ܸ� �߻���ų �� �ֵ��� ���ϰ�θ� �Ѽ�
		}//end if
		 
		FileInputStream fis=new FileInputStream(path);
		fis.close();
		model.addAttribute("msg", "���Ϸε� ����");
		
		return "day1108/success";
	}//exception2
	
	//�� Controller�ȿ��� �߻��� ��� IOException�� ��Ƽ� ó���ϴ� method
	@ExceptionHandler(IOException.class)
	//method�� �Ű������� ExceptionHandler�� ������ ����ó�� Ŭ������ ����
	public ModelAndView exceptionHandler(IOException ie) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("day1108/err");
		mav.addObject("errMsg", ie.toString());
		return mav;
	}//exceptionHandler
	
}
