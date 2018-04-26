<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#id").focus();
});
</script>
</head>
<body>
<div>
<h3>Intercepter Test</h3><h5>main page</h5>
<form action='signIn'method='post'>
ID: <input type='text'name='id'id='id'/></br>
PW: <input type='text'name='pw'/></br>
<button>SignIn</button>
</form>
<a href="main">go to main</a><br>
<%if(session.getAttribute("nick")!=null){
%>nick: <%=session.getAttribute("nick") %><%
}%>
<hr>
</div>
</body>
</html>