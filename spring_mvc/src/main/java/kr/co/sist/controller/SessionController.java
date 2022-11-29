package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"mName","mId"}) //설정된 이름과 model에 이름이 같다면 세션으로 할당
@Controller
public class SessionController {

	@RequestMapping(value="/day1103/set_httpsession.do", method=GET)
	public String setSession(HttpSession session) {
		
		//model에 설정된 값은 request에 설정된다.
		session.setMaxInactiveInterval(60*2); //request와 session에 동시 할당
		session.setAttribute("name", "차차"); //request와 session에 동시 할당
		session.setAttribute("id", "chacha"); //request에만 할당
		session.setAttribute("date", new Date());
		
		return "day1103/session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/get_httpsession.do", method=GET)
	public String getSession(HttpSession session) {
		
		System.out.println("이름:"+session.getAttribute("name"));
		System.out.println("아이디:"+session.getAttribute("id"));
		System.out.println("날짜:"+session.getAttribute("date"));
		
		return "day1103/get_session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/remove_httpsession.do", method=GET)
	public String removeSession(HttpSession session) {
		
		session.removeAttribute("name");
		session.removeAttribute("id");
		session.removeAttribute("date");
		
		session.invalidate();
		
		return "redirect:/day1103/use_session.jsp";
	}//setSession
	
	@RequestMapping(value="/day1103/set_model.do", method=GET)
	public String setModelSession(Model model) {
		
		//model에 설정된 값은 request에 설정된다.
		model.addAttribute("mName", "차차");//request와 session에 동시 할당
		model.addAttribute("mId", "chacha");//request와 session에 동시 할당
		model.addAttribute("mDate", new Date());//request에만 할당
		
		return "day1103/session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/get_model.do", method=GET)
	//spring 5.2부터는 ModelAttribute()가 추가 되었습니다.
	public String getModelSession(HttpSession session) {
		
		//model에 설정된 값은 request에 설정된다.
		System.out.println("m이름:"+session.getAttribute("mName"));
		System.out.println("m아이디:"+session.getAttribute("mId"));
		//session에 없어서 얻을 수 없다.
		System.out.println("m날짜:"+session.getAttribute("mDate")); 

		return "day1103/get_model_session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/remove_model.do", method=GET)
	//Model과 SessionAttributes설정한 session값을 HttpSession으로 삭제할 수 없다.
	//public String removeModelSession(HttpSession session) {
	//Model 저장된 session 값은 SessionStatus 객체를 매개변수로 받고
	public String removeModelSession(SessionStatus ss) {
		
		ss.setComplete(); //세션삭제
		
		return "redirect:/day1103/use_session.jsp";
	}//setSession
	
	
}//class
