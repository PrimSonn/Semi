<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<h4>File Upload.form</h4>
<form action ='fileUpload'method='post' enctype='multipart/form-data'>
	<label for='file'>add file</label>
	<input type='file' id='file' name='file'/><br>
	<button>send file</button>
</form>
</div>


</body>
</html>