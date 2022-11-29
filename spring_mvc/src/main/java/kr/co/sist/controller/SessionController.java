package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"mName","mId"}) //������ �̸��� model�� �̸��� ���ٸ� �������� �Ҵ�
@Controller
public class SessionController {

	@RequestMapping(value="/day1103/set_httpsession.do", method=GET)
	public String setSession(HttpSession session) {
		
		//model�� ������ ���� request�� �����ȴ�.
		session.setMaxInactiveInterval(60*2); //request�� session�� ���� �Ҵ�
		session.setAttribute("name", "����"); //request�� session�� ���� �Ҵ�
		session.setAttribute("id", "chacha"); //request���� �Ҵ�
		session.setAttribute("date", new Date());
		
		return "day1103/session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/get_httpsession.do", method=GET)
	public String getSession(HttpSession session) {
		
		System.out.println("�̸�:"+session.getAttribute("name"));
		System.out.println("���̵�:"+session.getAttribute("id"));
		System.out.println("��¥:"+session.getAttribute("date"));
		
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
		
		//model�� ������ ���� request�� �����ȴ�.
		model.addAttribute("mName", "����");//request�� session�� ���� �Ҵ�
		model.addAttribute("mId", "chacha");//request�� session�� ���� �Ҵ�
		model.addAttribute("mDate", new Date());//request���� �Ҵ�
		
		return "day1103/session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/get_model.do", method=GET)
	//spring 5.2���ʹ� ModelAttribute()�� �߰� �Ǿ����ϴ�.
	public String getModelSession(HttpSession session) {
		
		//model�� ������ ���� request�� �����ȴ�.
		System.out.println("m�̸�:"+session.getAttribute("mName"));
		System.out.println("m���̵�:"+session.getAttribute("mId"));
		//session�� ��� ���� �� ����.
		System.out.println("m��¥:"+session.getAttribute("mDate")); 

		return "day1103/get_model_session_result";
	}//setSession
	
	@RequestMapping(value="/day1103/remove_model.do", method=GET)
	//Model�� SessionAttributes������ session���� HttpSession���� ������ �� ����.
	//public String removeModelSession(HttpSession session) {
	//Model ����� session ���� SessionStatus ��ü�� �Ű������� �ް�
	public String removeModelSession(SessionStatus ss) {
		
		ss.setComplete(); //���ǻ���
		
		return "redirect:/day1103/use_session.jsp";
	}//setSession
	
	
}//class
