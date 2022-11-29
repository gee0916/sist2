<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="세션에 설정된 값"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<c:if test="${empty name}">
alert("세션에 값이 없습니다.");
location.href="use_session.jsp";
</c:if>
</script>
</head>
<body>
<strong>세션에 설정된 값얻기</strong>
<br>
<c:out value="${sessionScope.name }"/>(<c:out value="${id }"/>)
님 로그인 하셨습니다. <br>
접속 일자: <fmt:formatDate value="${date }" pattern="yyyy-MM-dd EEEE HH:mm"/>
<a href="use_session.jsp">메뉴</a>
</body>
</html>