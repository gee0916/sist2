package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

	@RequestMapping(value="/day1103/add_cookie.do", method=GET)
	//1. HttpServletResponse를 매개변수로 선언
	public String addCookie(HttpServletResponse response) {
		
		//2. 쿠키생성
		Cookie nameCookie=new Cookie("name1", "chacha");
		Cookie nameCookie2=new Cookie("name2", "김소현");
		
		//3. 생존시간 설정
		nameCookie.setMaxAge(60*60*24*1);
		nameCookie2.setMaxAge(60*60*24*1);
		
		//4. 심기
		response.addCookie(nameCookie);
		response.addCookie(nameCookie2);
		
		return "day1103/cookie_result";
		
	}//addCookie
	
	@RequestMapping(value="/day1103/read_cookie.do", method=GET)
	//1. HttpServletResponse를 매개변수로 선언
	public String readCookie(
			@CookieValue(value="name1", defaultValue="없음")String name, 
			@CookieValue(value="name2", defaultValue="포켓볼당구왕")String name2,
			Model model) {
		
		System.out.println("이름1:"+name);
		System.out.println("이름2:"+name2);
		
		model.addAttribute("cookie1",name);
		model.addAttribute("cookie2",name2);
		
		return "day1103/get_cookie";
		
	}//addCookie
	
	@RequestMapping(value="/day1103/remove_cookie.do", method=GET)
	//1. HttpServletResponse를 매개변수로 선언
	public String removeCookie(HttpServletResponse response) {
		
		//2. 쿠키생성
		Cookie nameCookie=new Cookie("name1", "");
		Cookie nameCookie2=new Cookie("name2", "");
		
		//3. 생존시간 설정
		nameCookie.setMaxAge(0);
		nameCookie2.setMaxAge(0);
		
		//4. 심기
		response.addCookie(nameCookie);
		response.addCookie(nameCookie2);
		
		return "day1103/cookie_result";
		
	}//addCookie

}

