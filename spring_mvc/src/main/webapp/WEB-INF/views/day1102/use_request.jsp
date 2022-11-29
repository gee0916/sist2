<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="scope 객체 저장된 값 사용하여 View 제작"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</script>
</head>
<body>
<a href="javascript:history.back()">뒤로</a><br>
<strong>관심 기업 주가</strong><br>
요청 처리 method명: <c:out value="${request_method }"/>
<div style="width: 500px">
<table class="table table-hover">
<tr>
<th style="width: 200px">이미지</th>
<th style="width: 120px">기업명</th>
<th style="width: 100px">주가</th>
</tr>
<c:if test="${empty comList }">
<tr>
<td colspan="3">관심기업이 없습니다.</td>
</tr>
</c:if>

<c:forEach var="com" items="${comList }">
<tr>
<td><img src="http://localhost/spring_mvc/common/images/${com.img }" style="width: 195px"></td>
<td><c:out value="${com.prdName }"/></td>
<td><fmt:formatNumber value="${com.price }" pattern="#,###"/>원</td>
</tr>
</c:forEach>

</table>
</div>
</body>
</html>