package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.service.AjaxService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AjaxController {

	@RequestMapping(value="/day1104/category.do", method=GET)
	public String category() {
		return "day1104/category";
	}
	
	@RequestMapping(value="/day1104/ajax_country.do", method=GET)
	public String country(Model model) {
		
		AjaxService as=new AjaxService();
		String jsonObj=as.country();
		model.addAttribute("country", jsonObj);
		
		return "day1104/json_country";
	}
	
	//JSP없이 JSONObject을 바로 접속자에게 제공
	@ResponseBody
	@RequestMapping(value="/day1104/ajax_maker.do", method=GET, produces="application/json;charset=UTF-8")
	public String maker(String country) { //JSP로 값을 전달하는 것이 아님로 Model을 정의하지 않는다.
		
		AjaxService as=new AjaxService();
		String jsonObj=as.searchMaker(country);
		
		return jsonObj;
	}
	
	/*
	public String maker(String country, Model model) {
		
		AjaxService as=new AjaxService();
		String jsonObj=as.searchMaker(country);
		model.addAttribute("maker", jsonObj);
		
		return "day1104/json_maker";
	}*/
	
	@ResponseBody
	@RequestMapping(value="/day1108/ajax_model.do", method=POST, produces="application/json;charset=UTF-8")
	public String model(String maker) {
		
		AjaxService as=new AjaxService();
		String jsonObj=as.searchModel(maker);
		
		return jsonObj;
	}
	
	/*
	@RequestMapping(value="/day1108/ajax_model.do", method=POST)
	public String model(String maker, Model model) {
		
		AjaxService as=new AjaxService();
		String jsonObj=as.searchModel(maker);
		model.addAttribute("model", jsonObj);
		
		return "day1108/json_model";
	}
	*/
}
