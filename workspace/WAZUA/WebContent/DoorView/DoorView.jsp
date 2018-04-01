<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		document.getElementById("signUp").onclick = function() {
			window.location.href = "<%= application.getContextPath() + application.getInitParameter("SignUp")%>";
		}
		document.getElementById("signIn").onclick = function() {
			window.location.href = "<%=	application.getContextPath() + application.getInitParameter("SignIn")%>";
		}
	}
</script>
</head>
<body>
	<p>DoorDriverView</p>
	<hr>
	<button id='signUp'>SignUp</button>
	<button id='signIn'>SignIn</button>
</body>
</html>