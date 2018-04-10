<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		
		document.getElementById('SignIn').onclick = function() {
				
			    var form = document.createElement('form');
			    form.setAttribute('method', 'post');
			    form.setAttribute('action', '<%= application.getContextPath() + application.getInitParameter("SignIn")%>');

	            var hiddenField = document.createElement('input');
	            hiddenField.setAttribute('type', 'hidden');
	            hiddenField.setAttribute('name', 'id');
	            hiddenField.setAttribute('value', 1);
	            form.appendChild(hiddenField);
	            
			    document.body.appendChild(form);
			    form.submit();
		}
	};
</script>
</head>
<body>
<div>
	SignInDriver
	<hr>
<!-- 	<button id='SignIn'>SignInAs ID#1</button> -->
	<form method='post'action='<%= application.getContextPath() + application.getInitParameter("SignIn")%>'>
		<input type='number'name='id'min='1'max='3'step='1'>
		<input type='submit'value='SignIn'>
	</form>
</div>

</body>
</html>