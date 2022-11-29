package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.vo.MemberVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
 * Web Parameter 처리는 3가지 방법으로 수행할 수 있다.
 * -HttpServletRequest
 * - 단일형 변수 사용
 * - VO 사용
 * 
 * Controller는 파라메터 처리, 파라메터 유효성 검증, XxxService사용, 
 * View페이지의 설정, 이동방식설정, 관계유지 객체의 사용 업무를 담당한다.
 * @author user
 *
 */
@Controller
public class ParameterController {
   @RequestMapping(value="/req_form.do", method = GET)
   public String reqForm() {
      return "param/req_form";
   }//reqForm
   
   /**
    * HttpServletRequest객체를 사용한 web parameter 값 받기
    * @param 
    * @return
    */
   @RequestMapping(value="/use_request.do", method =POST)
   public String useRequest(HttpServletRequest request) throws UnsupportedEncodingException {
      
      request.setCharacterEncoding("UTF-8");
      //이름이 유일
      String id=request.getParameter("id");
      String pass=request.getParameter("pass");
      String birth=request.getParameter("birth");
      String email1=request.getParameter("email1");
      String email2=request.getParameter("email2");
      String emailFlag=request.getParameter("emailFlag");
      String gender=request.getParameter("gender");
      String paramAge=request.getParameter("age");
      
      int age=0;
      try {
      age=Integer.parseInt(paramAge);
      }catch(NumberFormatException nfe) {
         
      }//end catch
      
      //이름이 중복
      String[] lang=request.getParameterValues("lang");
      
      MemberVO mVO=
            new MemberVO( id,pass,birth,email1,email2, emailFlag, gender, lang, age);
      
      System.out.println("web parameter : " +mVO);
      
      return "param/req_form_result";
   }//useRequest
   
   @RequestMapping(value="/single_form.do", method =GET)
   public String singleForm() {
      return "param/single_form";
   }//singleForm
   
   /** 단일 데이터형으로 값 받기
    * 형변환은 Spring Framework에서 수행해준다. 
    * (web parameter는 문자열로만 넘어온다 -> String으로만 받아야하는데 
    * int
    * )
    * 중요 : - HTML Form Control의 이름과 매개변수명은 같아야한다.
    *          - int형으로 선언된 매개변수에는 반드시 값이 들어와야한다(안그러면 에러남)
    * 
    * @return
    */
   @RequestMapping(value = "/use_single_data.do", method = POST)
   public String useSingleData(String id, String pass, String birth, String email1,String email2, 
         String emailFlag, String gender, String[] lang, 
         @RequestParam(required=false, defaultValue ="0") int age)  throws NumberFormatException {
      //HttpServletRequest를 사용하지 않고 웹 파라메터를 받을 수 있다
      MemberVO mVO=
            new MemberVO( id,pass,birth,email1,email2, emailFlag, gender, lang, age);
      
      System.out.println("web parameter를 단일형으로 처리 : " +mVO);
      
      return "param/single_form_result";
   }//useSingleData
   
   /**VO를 사용한 Web Parameter받기
    * 매개변수가 VO인 경우에는 defaultValue 사용할 수 없다->
    * defaultValue는 VO에 setter method에 정의한다
    * @return
    */
   @RequestMapping(value="/vo_form.do", method =GET)
   public String voForm() {
      return "param/vo_form";
   }//singleForm
   
   @RequestMapping(value = "/use_vo_data.do", method = POST)
   public String useVOData(@RequestParam(defaultValue="0") MemberVO mVO){
      System.out.println("web parameter를 vo로 처리 : " +mVO);
      
      return "param/vo_form_result";
   }//useSingleData
   
   @ExceptionHandler(NumberFormatException.class)
	public ModelAndView numberFormatException (NumberFormatException nfe) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("day1108/err_num");
		mav.addObject("outMsg", "숫자만 입력가능");
		mav.addObject("errObj", nfe); //예외처리객체가 할당
		return mav;
	}//NumberFormatException
   
}//class