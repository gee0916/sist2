package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

/**
 * 요청방식에 대한 method 호출
 * @author user
 */
@Controller
public class RequestController {

	/**
	 * get방식의 요청
	 * @return
	 */
	@RequestMapping(value="/getMethod.do",method=RequestMethod.GET)
	public String getRequest() {
		return "get";
	}
	
	/**
	 * post방식의 요청
	 * @return
	 */
	@RequestMapping(value="/postMethod.do",method=RequestMethod.POST)
	public String postRequest() {
		return "post";
	}
	
	/**
	 * get방식과 post방식의 모든 요청을 처리
	 * @return
	 */
	@RequestMapping(value="/get_post_method.do",method= {RequestMethod.GET,RequestMethod.POST})
	public String getPostRequest() {
		return "get_post";
	}
	
	/**
	 * 하나의 method가 여러 요청을 받아서 처리할 때.
	 * => 배열 : {"요청 URL","요청 URL","요청 URL",,,,}
	 * @return
	 */
	@RequestMapping(value={"/a.do","/b.do","/c.do","/yana.do"}, method=GET)
	public String multiRequest(HttpServletRequest request, Model model) {
		//System.out.println("요청 URL "+request.getRequestURL());
		model.addAttribute("first_url",request.getRequestURL());
		return "multi_request";
	}
	
	@RequestMapping(value="/sub/sub_request.do", method=GET)
	public String subRequest() {
		return "sub";
	}//subRequest
	
	/**
	 * 요청 URL(URI)과 응답 JSP의 이름이 같다면 method의 반환형을 void로 하고
	 * return 페이지명을 생략할 수 있다.
	 */
	@RequestMapping(value="/void_test.do", method=GET)
	public void sameName() {
		System.out.println("요청명과 JSP명이 같을 때");
	}
	
	@RequestMapping(value="/sub_jsp.do",method=GET)
	public String subDirJp() {
		//return "sub_dir"; //WEB-INF/views/하위에서 같은 이름의 jsp를 찾는다.
		return "day1101/sub_dir"; //WEB-INF/views/day1101 하위에서 같은 이름의 jsp를 찾는다.
	}
}//class
