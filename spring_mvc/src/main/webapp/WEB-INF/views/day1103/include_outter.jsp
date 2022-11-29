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
</script>
</head>
<body>
외부 JSP
<div>
<jsp:include page="/day1103/jsp_webapp.jsp"/>
</div>
<div>
<!-- /WEB-INF/views 존재하는 JSP는 Controller에서 처리한 데이터를
보여주는 JSP이므로 직접 include하면 데이터를 보여줄 수 없다.
.do 요청하여 JSP include해야한다.  -->
<jsp:include page="/WEB-INF/views/day1103/jsp_views.jsp"/>
</div>
<div>
<strong>JSP를 직접 include</strong><br>
<jsp:include page="/WEB-INF/views/day1102/use_request.jsp"/>
</div>
<div>
<strong>do를 요청하여 JSP가 include</strong><br>
<jsp:include page="/day1102/use_model.do"/>
</div>
외부 JSP
</body>
</html>