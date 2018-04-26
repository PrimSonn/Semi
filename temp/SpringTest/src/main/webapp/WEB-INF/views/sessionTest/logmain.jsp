<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>main</h5>
<hr>
<%if(session.getAttribute("id")!=null){
	%><h6>logged in!</h6>
	<a href='out'>logout</a><br>
	<a href='mypage'>mypage</a><br><%
}
else {
	%><h6>not logged in</h6>
	<a href='in'>login</a><br>
	<a href='join'>join</a><br><%
}%>
</body>
</html>