<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSignIn").click(function(){
		location.href="signIn";
	});
	$("#btnSignOut").click(function(){
		location.href="signOut";	
	});
	$("#btnAdmin").click(function(){
		location.href="admin/main";
	});
	$("#btnForum").click(function(){
		location.href="forum/list";
	});
});
</script>
</head>
<body>
<div>
<h3>Intercepter Test</h3><h5>main page</h5>
<c:if test="${empty nick }"><button id='btnSignIn'>SignIn</button></c:if>
<c:if test="${!empty nick }"><button id='btnSignOut'>SignOut</button></c:if>
<button id='btnAdmin'>Admin</button>
<button id='btnForum'>forum</button>
<br>id: ${nick }
</div>
</body>
</html>