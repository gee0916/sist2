package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;

/**
 * ��û��Ŀ� ���� method ȣ��
 * @author user
 */
@Controller
public class RequestController {

	/**
	 * get����� ��û
	 * @return
	 */
	@RequestMapping(value="/getMethod.do",method=RequestMethod.GET)
	public String getRequest() {
		return "get";
	}
	
	/**
	 * post����� ��û
	 * @return
	 */
	@RequestMapping(value="/postMethod.do",method=RequestMethod.POST)
	public String postRequest() {
		return "post";
	}
	
	/**
	 * get��İ� post����� ��� ��û�� ó��
	 * @return
	 */
	@RequestMapping(value="/get_post_method.do",method= {RequestMethod.GET,RequestMethod.POST})
	public String getPostRequest() {
		return "get_post";
	}
	
	/**
	 * �ϳ��� method�� ���� ��û�� �޾Ƽ� ó���� ��.
	 * => �迭 : {"��û URL","��û URL","��û URL",,,,}
	 * @return
	 */
	@RequestMapping(value={"/a.do","/b.do","/c.do","/yana.do"}, method=GET)
	public String multiRequest(HttpServletRequest request, Model model) {
		//System.out.println("��û URL "+request.getRequestURL());
		model.addAttribute("first_url",request.getRequestURL());
		return "multi_request";
	}
	
	@RequestMapping(value="/sub/sub_request.do", method=GET)
	public String subRequest() {
		return "sub";
	}//subRequest
	
	/**
	 * ��û URL(URI)�� ���� JSP�� �̸��� ���ٸ� method�� ��ȯ���� void�� �ϰ�
	 * return ���������� ������ �� �ִ�.
	 */
	@RequestMapping(value="/void_test.do", method=GET)
	public void sameName() {
		System.out.println("��û��� JSP���� ���� ��");
	}
	
	@RequestMapping(value="/sub_jsp.do",method=GET)
	public String subDirJp() {
		//return "sub_dir"; //WEB-INF/views/�������� ���� �̸��� jsp�� ã�´�.
		return "day1101/sub_dir"; //WEB-INF/views/day1101 �������� ���� �̸��� jsp�� ã�´�.
	}
}//class
