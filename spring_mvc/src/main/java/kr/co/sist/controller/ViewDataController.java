package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.service.TestService;
import kr.co.sist.vo.ProductVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller���� View�������� �����͸� �����ϴ� ���.
 * HttpServletRequest, Model, ModelAndView
 * @author user
 */
@Controller
public class ViewDataController {
	
	@RequestMapping(value="/day1102/use_request.do",method=GET)
	public String useRequest(HttpServletRequest request) {
		
		TestService ts = new TestService();
		List<ProductVO> list=ts.companyList();
		//request scope ��ü�� ���� �ִ´�.scope��ü�� ����� ���� JSP�� ���޵ȴ�.
		request.setAttribute("comList", list);
		request.setAttribute("request_method", "useRequest");
		
		return "day1102/use_request";
	}
	
	@RequestMapping(value="/day1102/use_model.do",method=GET)
	public String useModel(Model model) {
		
		TestService ts = new TestService();
		List<ProductVO> list=ts.companyList();
		//Model interface�� �ڽ� ��ü�� ���� �ִ´�. (��ü������)
		//��ü�� ����� ���� request��ü�� ����Ǿ� JSP�� ���޵ȴ�.
		//JSP������ ${requestScope.�̸�}���� ����� �� �ִ�.
		model.addAttribute("comList", list);
		model.addAttribute("request_method", "useModel");
		
		return "day1102/use_request";
	}//useModel
	
	
	/**
	 * ModelAndView�� ����Ͽ� �����Ϳ� ���������� ��� ó��
	 * @return
	 */
	@RequestMapping(value="/day1102/use_mav.do",method=GET)
	//1.��ȯ���� ModelAndView�� �����Ǿ�� �Ѵ�.
	public ModelAndView useModelAndView() {
		
		TestService ts = new TestService();
		List<ProductVO> list=ts.companyList();
		//2.ModelAndView�� ����
		ModelAndView mav=new ModelAndView();
		
		//3.View ���������� ����
		mav.setViewName("day1102/use_request");
		
		//4.JSP�� ������ ������ ����
		mav.addObject("comList", list);
		mav.addObject("request_method", "useModelAndView");
		//5.view�������� ���� ���� ModelAndView ��ü�� ��ȯ
		return mav;
	}//useModel
}//class
