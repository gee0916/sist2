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
	//1. HttpServletRequest ��´�
	public String uploadProcess(HttpServletRequest request, Model model) {
		//2. FileUpload Component�� ���� (cos.jar)
		File saveDir=new File("E:/dev/workspace_spring/spring_mvc/src/main/webapp/upload/");
		int maxSize=1024*1024*20;// byte "kb" "mb" "gb"
		String responseURL="/day1104/upload_err";
		
		try {
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			//3.  �Ķ���͸� �ޱ� (VO�� �־�� �Ѵٸ� VO�� �����Ͽ� ���� �ִ´�.)
			UploadVO uVO=new UploadVO();
			uVO.setUploader(mr.getParameter("uploader"));
			uVO.setAge(Integer.parseInt(mr.getParameter("age")));
			uVO.setUpfile(mr.getFilesystemName("upfile"));
			
			//JSP���� �Է°��� �����ֱ� ���� model�� VO�� �ִ´�.
			model.addAttribute("viewData",uVO);
			
			responseURL="/day1104/upload_success";
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return responseURL;
	}//uploadProcess
	
}
