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
 * Controller에서 View페이지로 데이터를 전달하는 방법.
 * HttpServletRequest, Model, ModelAndView
 * @author user
 */
@Controller
public class ViewDataController {
	
	@RequestMapping(value="/day1102/use_request.do",method=GET)
	public String useRequest(HttpServletRequest request) {
		
		TestService ts = new TestService();
		List<ProductVO> list=ts.companyList();
		//request scope 객체에 값을 넣는다.scope객체에 저장된 값은 JSP로 전달된다.
		request.setAttribute("comList", list);
		request.setAttribute("request_method", "useRequest");
		
		return "day1102/use_request";
	}
	
	@RequestMapping(value="/day1102/use_model.do",method=GET)
	public String useModel(Model model) {
		
		TestService ts = new TestService();
		List<ProductVO> list=ts.companyList();
		//Model interface의 자식 객체에 값을 넣는다. (객체다형성)
		//객체에 저장된 값은 request객체에 저장되어 JSP로 전달된다.
		//JSP에서는 ${requestScope.이름}으로 사용할 수 있다.
		model.addAttribute("comList", list);
		model.addAttribute("request_method", "useModel");
		
		return "day1102/use_request";
	}//useModel
	
	
	/**
	 * ModelAndView를 사용하여 데이터와 뷰페이지를 묶어서 처리
	 * @return
	 */
	@RequestMapping(value="/day1102/use_mav.do",method=GET)
	//1.반환형이 ModelAndView로 설정되어야 한다.
	public ModelAndView useModelAndView() {
		
		TestService ts = new TestService();
		List<ProductVO> list=ts.companyList();
		//2.ModelAndView를 생성
		ModelAndView mav=new ModelAndView();
		
		//3.View 페이지명을 설정
		mav.setViewName("day1102/use_request");
		
		//4.JSP로 전달할 데이터 설정
		mav.addObject("comList", list);
		mav.addObject("request_method", "useModelAndView");
		//5.view페이지와 값을 가진 ModelAndView 객체를 반환
		return mav;
	}//useModel
}//class
