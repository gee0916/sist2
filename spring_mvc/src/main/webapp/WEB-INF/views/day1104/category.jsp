<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- Bootstrap Css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- Bootstrap Js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	setCountry();
	
	$("#country").change(function(){
		if($("#country").val() != "none"){
			setMaker();
		}//end if
	});
	
	$("#maker").change(function(){
		if($("#maker").val() != "none"){
			setModel();
		}//end if
	});
});//ready

function setCountry(){
	$.ajax({
		url:"ajax_country.do",
		dataType: "json",
		error: function( xhr ){
			alert("제조국을 조회하는 문제 발생했습니다. 잠시 후 다시 시도");
			console.log( xhr.status);
		},
		success: function( jsonObj ){
			if( jsonObj.result ){
				var countrySel=document.categoryFrm.country;
				$.each( jsonObj.countryData,function(i, json){
					countrySel.options[i+1]=new Option( json.country, json.country);
				} );
			}//end if
		}//success
	});
}//setCountry

function setMaker(){
	$.ajax({
		url:"http://localhost/spring_mvc/day1104/ajax_maker.do",
		data:"country="+$("#country").val(),
		dataType : "json",
		error:function( xhr ){
			alert("제조사 조회도중 문제가 발생하였습니다. console을 확인 해주세요.");
			console.log("어쩔티비 저쩔티비 우짤래미 저짤래미 에러났쥬~ 개킹받쥬~"+ xhr.status);
		},
		success: function( jsonObj ){
			if( jsonObj.resultFlag ){
				var makerSel=document.categoryFrm.maker;
				//<select>의 <option>을 하나만 남겨두고 초기화
				makerSel.length=1;
				
				$.each( jsonObj.makerData,function(i, json){
					makerSel.options[i+1]=new Option( json.maker, json.maker);
				} );
			}//end if
		}
	});//ajax
}//setMaker

function setModel(){
	$.ajax({
		url:"http://localhost/spring_mvc/day1108/ajax_model.do",
		type: "post",
		data:"maker="+$("#maker").val(),
		dataType : "json",
		error:function( xhr ){
			alert("모델 조회 중 문제발생");
			console.log("어쩔티비 저쩔티비 뇌절티비"+ xhr.status);
		},
		success: function( jsonObj ){
			if( jsonObj.resultFlag ){
				var modelSel=document.categoryFrm.model;
				//<select>의 <option>을 하나만 남겨두고 초기화
				modelSel.length=1;
				
				$.each( jsonObj.data,function(i, json){
					modelSel.options[i+1]=new Option( json.model, json.model);
				} );
			}//end if
		}
	});//ajax
}//setMaker

</script>

</head>
<body>
<div>
<form name="categoryFrm" >
<select name="country" id="country">
<option value="none">---제조국---</option>
</select>
<select name="maker" id="maker">
<option value="none">---제조사---</option>
</select>
<select name="model" id="model">
<option value="none">---모델---</option>
</select>
</form>
</div>
</body>
</html>