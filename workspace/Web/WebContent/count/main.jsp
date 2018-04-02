<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='http://code.jquery.com/jquery-2.2.4.min.js'></script>
<script>
	$(document).ready(function(){
		$('#btnUp').click(function(){
			location.href='/plusCount.do';
		});
	});
	
</script>

</head>
<body>
	<h1>Count UP!</h1>
<%-- 	${cnt}<br> --%>
<%-- 		${cnt.cnt } --%>
<%-- 	${requestScope.cnt.cnt} --%>
	<input id='cnt'type='text'size='5'value='${cnt.cnt}'readonly/>
	<button id='btnUp'>Like</button>
</body>
</html>