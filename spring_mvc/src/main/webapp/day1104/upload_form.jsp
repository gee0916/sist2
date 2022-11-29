<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="RFC 1867" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.149/spring_mvc/common/css/main_v1_220901.css"/>
<style type="text/css">

</style>
<!-- jQuery google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <!-- Bootstrap JS -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		//확장자가 jpg,gif,jpeg,png,bmp 만 업로드 가능하도록 JS 코드작성.
		var fileName=$("#upfile").val();
		var blockExt="jpg,gif,jpeg,png,bmp".split(",");
		var flag=false;
		
		if( fileName == ""){
			alert("업로드할 파일을 선택해주세요.");
			return;
		}//end if
		
		var fileExt=fileName.substring(fileName.lastIndexOf(".")+1);
		for(var i= 0 ; i < blockExt.length ; i++){
			if(blockExt[i] == fileExt){
				 flag=true;
			}//end if
		}//end for
		
		if(!flag){
			alert("이미지파일만 업로드 가능");
			return;
		}//end if
		
		$("form").submit();
	});
});//ready
</script>

</head>
<body>
 
 <!-- RFC 1867 HTML Form 기반의 file upload -->
 <form action="upload_form_process.do" enctype="multipart/form-data" method="post">
 <label>업로더</label>
 <input type="text" name="uploader" class="inputBox" value="차본좌"/><br/>
 <label>나이</label>
 <select name="age">
 
 <option value="10">10대</option>
 
 <option value="20">20대</option>
 
 <option value="30">30대</option>
 
 <option value="40">40대</option>
 
 <option value="50">50대</option>
 
 <option value="60">60대</option>
 
 <option value="70">70대</option>
 
 <option value="80">80대</option>
 
 </select><br/>
 <input type="file" name="upfile" id="upfile"/>
 <br/>
 <input type="button" value="업로드" class="inputBtn" id="btn"/>
 </form>
</body>
</html>





