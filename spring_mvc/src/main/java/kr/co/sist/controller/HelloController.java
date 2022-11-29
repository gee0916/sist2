package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//DispatcherServlet이 요청이 들어온 URL을 처리하기위해
//HandlerMapper를 실행하여 요청을 처리할 수 있는 Controller를 찾는 일을 시킨다.
//이때 HandlerMapper는 많은 클래스 중 @Controller annotation이 선언되어있는
//클래스만 검색한다.
@Controller
public class HelloController {

	//*method하나가 요청 하나를 처리
	//요청을 처리하는 method를 요청 URL과 매핑 시키기 위해서
	//@RequestMapping annotation사욯한다.
	//@RequestMapping(value="매핑URI", method=요청방식)
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public String helloWork() {
		
		System.out.println("hello.do의 요청이 들어왔음");
		//리턴되는 문자열을 ViewResolver가 받아서 /WEB-INF/views에 JSP파일로
		//존재하는 지 찾고, 존재하면 기본 forword로 이동
		//ViewResolver는 리턴되는 문자열의 앞에 (prefix) /WEB-INF/views/를 붙이고
		//뒤에 (suffix).jsp를 붙여서 찾는다. : 설정은 servlet-context.xml에 들어있음.
		
		return "hello"; 
		
	}//helloWork
	
	
}
