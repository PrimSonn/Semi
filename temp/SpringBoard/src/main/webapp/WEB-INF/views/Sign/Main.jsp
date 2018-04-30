<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>Sign.MainPage</h3>
<%String id = (String)session.getAttribute("id");
if(id==null){%>
<a href='Up'><button>SignUp</button></a>
<a href='In'><button>SignIn</button></a>
<%}else{%>
<a href='Out'><button>SignOut</button></a><br>
ID: <%=id%>
<%}%>
<hr>
<a href='../list'>list</a>
</body>
</html>