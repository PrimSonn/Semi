<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>SessionTest Page</h4>
<br>
<h3><a href='info'>make SessionAttr</a></h3>
<h3><a href='delete'>Invalidate Session</a></h3><br>

<h5>SessionAttr1: ${sessionScope.1 }</h5>
<h5>SessionAttr2: ${sessionScope.2 }</h5>
<h5>SessionAttr3: ${sessionScope.3 }</h5>

</body>
</html>