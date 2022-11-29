package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class includeController {

	@RequestMapping(value="day1103/use_include.do", method=GET)
	public String testInclude() {
		return "day1103/include_outter";
	}
	
}
