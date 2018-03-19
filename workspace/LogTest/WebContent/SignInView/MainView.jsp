<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){ 
		
		document.getElementById("SignOut").onclick = function() {
			window.location.href = "http://localhost:8001/LogTest/SignOut";
		}
	}
</script>
</head>
<body>
	<p>MainView</p>
	<button id='SignOut'>SignOut</button>
</body>
</html>