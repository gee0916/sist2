<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.149/spring_mvc/common/css/main_v1_220901.css"/>
<style type="text/css">
tr{ height: 30px }
#passMsg{ color:#FF0000 }
</style>
<!-- jQuery google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnAdd").click(function(){
		//null 검사
		chkNull();
	});//click
});//ready

function chkNull(){
	$("#memberFrm").submit();
}
</script>
</head>
<body>
<a href="#void">링크</a>
<h2>단일형을 사용한 회원가입</h2>
	<form method="post" action="use_single_data.do" id="memberFrm">
	
		<table border="0">
			<tr>
				<td ><span class="red">*</span>아이디</td>
				<td><input type="text" name="id" id="id" class="inputBox"></td>
			</tr>
			<tr>
				<td><span class="red">*</span>비밀번호</td>
				<td><input type="password" id="pass"   name="pass" class="inputBox">
					</td>
			</tr>
			<tr>
				<td><span class="red">*</span>나이</td>
				<td><input type="text" id="age" name="age" class="inputBox" value="20">
					</td>
			</tr>
			<tr>
				<td><span class="red">*</span>생일</td>
				<td><input type="date" class="inputBox"  name="birth"></td>
			</tr>
			<tr>
				<td><span class="red">*</span>이메일</td>
				<td><input type="email" class="inputBox"  name="email1" style="width:150px">@ 
						<select class="inputBox"  name="email2" >
						<option>선택해주세요</option>
						<option>googl.com</option>
						<option>daum.net</option>
						<option>nate.com</option>
						<option>naver.com</option>
						<option>hotmail.com</option>
						<option>직접입력</option>
						</select> <input type="checkbox"  name="emailFlag" value="Y"><small>수신</small></td>
			</tr>
			<tr>
				<td><span class="red">*</span>성별</td>
				<td><input type="radio" id="man" name="gender" value="m">
					<label>남자</label> 
					<input type="radio" 	id="woman" name="gender" value="w"><label>여자</label>
				</td>
			</tr>
			<tr>
				<td ><span class="red">*</span>관심언어</td>
				<td> 
						<input type="checkbox" name="lang" value="java"> 자바
						<input type="checkbox" name="lang" value="C/C++"> C/C++
						<input type="checkbox" name="lang" value="VB"> 비주얼베이직 
						<input type="checkbox" name="lang" value="PyThon"> PyThon
						<input type="checkbox" name="lang" value="C#"> C#
				</td>
			</tr>
		</table>
		<br>
		<table>
			<tr align="center">
				<td><input type="button" value="확인" id="btnAdd" class="inputBtn">
				<input type="reset" value="취소" class="inputBtn"></td>
		</table>
	</form>

</body>
</html>