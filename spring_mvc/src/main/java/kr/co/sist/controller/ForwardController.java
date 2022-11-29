package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * ����� �ٸ� do�� �����ؼ ������ ��
 * {forward chain}
 * @author user
 */
@Controller
public class ForwardController {

	@RequestMapping(value="/day1102/forward_chain.do", method=GET)
	public String firstReauest(String param) {
		String url="redirect:http://localhost/spring_mvc/hello.do";
		
		if(param!=null) {
			url="forward:work.do"; //ViewResolver�� ��ġ�� �ʰ� do�� �����Ͽ� ��û
		}//end if
		
		return url;
	}//firstReauest
	
	@RequestMapping("/day1102/work.do")
	public String secondRequest() {
		
		return "day1102/work"; //ViewResolver�� ����� �̵�
	}
	
}
