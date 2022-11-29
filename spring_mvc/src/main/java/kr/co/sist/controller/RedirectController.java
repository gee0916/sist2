package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * redirect에 대한 이동
 * @author user
 */
@Controller
public class RedirectController {

	@RequestMapping(value = "/day1102/redirect_test.do", method=GET)
	public String doRequest() {
		
		//redirect로 이동할 때에는 "redirect:이동할 페이지 URL 또는 URI"
		//return "../hello.do"; // WEB-INF/hello.do.jsp => error
		//return "redirect:../hello.do";
		return "redirect:http://localhost/spring_mvc/hello.do"; //URL
	}
	
	@RequestMapping(value = "/day1102/redirect_jsp.do", method=GET)
	public String jspRequest() {
		
		//return "redirect:redirect_result.jsp"; //URL
		return "redirect:http://localhost/spring_mvc/day1102/redirect_result.jsp"; //URL
	}//jspRequest
	
}//class
