<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SignInjsp</h1>
	<form action='/web/hello'method='post'>
		<label for='id'>ID: <input type="text"name='id'></label><br>
		<label for='pw'>PW: <input type="text"name='pw'><br></label>
		<input type='submit'value='signIn'>
	</form>
</body>
</html>