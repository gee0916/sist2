package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 등답을 다른 do로 연결해쇼서 수행할 때
 * {forward chain}
 * @author user
 */
@Controller
public class ForwardController {

	@RequestMapping(value="/day1102/forward_chain.do", method=GET)
	public String firstReauest(String param) {
		String url="redirect:http://localhost/spring_mvc/hello.do";
		
		if(param!=null) {
			url="forward:work.do"; //ViewResolver를 거치지 않고 do를 연결하여 요청
		}//end if
		
		return url;
	}//firstReauest
	
	@RequestMapping("/day1102/work.do")
	public String secondRequest() {
		
		return "day1102/work"; //ViewResolver를 사용한 이동
	}
	
}
