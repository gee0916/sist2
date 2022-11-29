package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.vo.UploadVO;

@Controller
public class FileController {

	@RequestMapping(value="/day1104/upload_form_process.do", method=POST)
	//1. HttpServletRequest 얻는다
	public String uploadProcess(HttpServletRequest request, Model model) {
		//2. FileUpload Component를 생성 (cos.jar)
		File saveDir=new File("E:/dev/workspace_spring/spring_mvc/src/main/webapp/upload/");
		int maxSize=1024*1024*20;// byte "kb" "mb" "gb"
		String responseURL="/day1104/upload_err";
		
		try {
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			//3.  파라메터를 받기 (VO에 넣어야 한다면 VO를 생성하여 값을 넣는다.)
			UploadVO uVO=new UploadVO();
			uVO.setUploader(mr.getParameter("uploader"));
			uVO.setAge(Integer.parseInt(mr.getParameter("age")));
			uVO.setUpfile(mr.getFilesystemName("upfile"));
			
			//JSP에서 입력값을 보여주기 위해 model에 VO를 넣는다.
			model.addAttribute("viewData",uVO);
			
			responseURL="/day1104/upload_success";
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return responseURL;
	}//uploadProcess
	
}
