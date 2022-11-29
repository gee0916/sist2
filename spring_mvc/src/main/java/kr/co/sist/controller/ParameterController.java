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
 * Web Parameter ó���� 3���� ������� ������ �� �ִ�.
 * -HttpServletRequest
 * - ������ ���� ���
 * - VO ���
 * 
 * Controller�� �Ķ���� ó��, �Ķ���� ��ȿ�� ����, XxxService���, 
 * View�������� ����, �̵���ļ���, �������� ��ü�� ��� ������ ����Ѵ�.
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
    * HttpServletRequest��ü�� ����� web parameter �� �ޱ�
    * @param 
    * @return
    */
   @RequestMapping(value="/use_request.do", method =POST)
   public String useRequest(HttpServletRequest request) throws UnsupportedEncodingException {
      
      request.setCharacterEncoding("UTF-8");
      //�̸��� ����
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
      
      //�̸��� �ߺ�
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
   
   /** ���� ������������ �� �ޱ�
    * ����ȯ�� Spring Framework���� �������ش�. 
    * (web parameter�� ���ڿ��θ� �Ѿ�´� -> String���θ� �޾ƾ��ϴµ� 
    * int
    * )
    * �߿� : - HTML Form Control�� �̸��� �Ű��������� ���ƾ��Ѵ�.
    *          - int������ ����� �Ű��������� �ݵ�� ���� ���;��Ѵ�(�ȱ׷��� ������)
    * 
    * @return
    */
   @RequestMapping(value = "/use_single_data.do", method = POST)
   public String useSingleData(String id, String pass, String birth, String email1,String email2, 
         String emailFlag, String gender, String[] lang, 
         @RequestParam(required=false, defaultValue ="0") int age)  throws NumberFormatException {
      //HttpServletRequest�� ������� �ʰ� �� �Ķ���͸� ���� �� �ִ�
      MemberVO mVO=
            new MemberVO( id,pass,birth,email1,email2, emailFlag, gender, lang, age);
      
      System.out.println("web parameter�� ���������� ó�� : " +mVO);
      
      return "param/single_form_result";
   }//useSingleData
   
   /**VO�� ����� Web Parameter�ޱ�
    * �Ű������� VO�� ��쿡�� defaultValue ����� �� ����->
    * defaultValue�� VO�� setter method�� �����Ѵ�
    * @return
    */
   @RequestMapping(value="/vo_form.do", method =GET)
   public String voForm() {
      return "param/vo_form";
   }//singleForm
   
   @RequestMapping(value = "/use_vo_data.do", method = POST)
   public String useVOData(@RequestParam(defaultValue="0") MemberVO mVO){
      System.out.println("web parameter�� vo�� ó�� : " +mVO);
      
      return "param/vo_form_result";
   }//useSingleData
   
   @ExceptionHandler(NumberFormatException.class)
	public ModelAndView numberFormatException (NumberFormatException nfe) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("day1108/err_num");
		mav.addObject("outMsg", "���ڸ� �Է°���");
		mav.addObject("errObj", nfe); //����ó����ü�� �Ҵ�
		return mav;
	}//NumberFormatException
   
}//class