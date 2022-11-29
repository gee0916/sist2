package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.DiService;
import kr.co.sist.service.DiService2;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class DIController2 {
	
	//����������
	@Autowired(required = false)
	private DiService2 dis2;
	
	@RequestMapping(value="/day1110/use_di2.do", method=GET)
	public String useDi(Model model) {
		
		//2. @Autowired�� ������ ���Թ��� ��ü�� ���
		model.addAttribute("data", dis2.searchMaker());
		System.out.println("@Autowired�� ������ ���Թ��� Service�� ���");
		return "day1110/maker";
	}//useDi
	
}//class
