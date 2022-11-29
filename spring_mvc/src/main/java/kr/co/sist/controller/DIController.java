package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.DiService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class DIController {
	
	@RequestMapping(value="/day1110/use_di.do", method=GET)
	public String useDi(Model model) {
		
		//1. Spring Container »ý¼º
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/config/applicationContext.xml");
		
		//2. 
		DiService dis=ac.getBean(DiService.class);
		
		model.addAttribute("data", dis.searchMaker());
		
		//3. 
		((ClassPathXmlApplicationContext)ac).close();
		
		return "day1110/maker";
	}//useDi
	
}//class
