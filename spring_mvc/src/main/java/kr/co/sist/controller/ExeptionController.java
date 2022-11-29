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

	//method가 호출될때 발생하는 예외는 DispatcherServlet이 잡는다. => 예외발생시
	//응답 페이지를 개발자가 설정할 수 없다.
	@RequestMapping(value="/day1108/exception1.do", method=GET )
	public String exception1(Model model) throws ClassNotFoundException {
		
		String loadClass="java.lang.String";
		
		if(new Random().nextBoolean()) {
			loadClass="java.lang.String1";
		}//end if
		
		Class.forName(loadClass);
		model.addAttribute("msg", "클래스로딩 성공");
		
		return "day1108/success";
	}//exception
	
	/**
	 * 발생된 예외를 DispatcherServlet이 아닌 개발자가 정의한 method에서 처리.
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/day1108/exception2.do", method=GET )
	public String exception2(Model model) throws IOException {
		
		String path="E:/dev/workspace_spring/spring_mvc/src/main/java/kr/co/sist/controller/ExeptionController.java";
		
		if(new Random().nextBoolean()) {
			path+="1";// 예외를 발생시킬 수 있도록 파일경로를 훼손
		}//end if
		 
		FileInputStream fis=new FileInputStream(path);
		fis.close();
		model.addAttribute("msg", "파일로딩 성공");
		
		return "day1108/success";
	}//exception2
	
	//이 Controller안에서 발생한 모든 IOException을 모아서 처리하는 method
	@ExceptionHandler(IOException.class)
	//method의 매개변수를 ExceptionHandler와 동일한 예외처리 클래스로 정의
	public ModelAndView exceptionHandler(IOException ie) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("day1108/err");
		mav.addObject("errMsg", ie.toString());
		return mav;
	}//exceptionHandler
	
}
