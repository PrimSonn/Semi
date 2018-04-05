<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	window.onload = function(){
		<%for(int i=1;i<4;i++){%>
		document.getElementById('movie<%=i%>').onclick = function() {
		    var form = document.createElement('form');
		    form.setAttribute('method', 'post');
		    form.setAttribute('action', '<%= application.getContextPath() + application.getInitParameter("MoviePage")%>');

            var hiddenField = document.createElement('input');
            hiddenField.setAttribute('type', 'hidden');
            hiddenField.setAttribute('name', 'mvIdx');
            hiddenField.setAttribute('value', <%=i%>);
            form.appendChild(hiddenField);
            
		    document.body.appendChild(form);
		    form.submit();
		}
		<%}%>
	};
</script>
<body>
	<div>
		<h2>MainPageDriver</h2>
		<hr>
		<% for (int i=1;i<4;i++) { %>
		<button id='movie<%=i%>'>Movie <%=i%></button><br>
		<% }%>
		<a href="<%=application.getContextPath()+application.getInitParameter("SignOut") %>">
			<button>SignOut</button>
		</a>
	</div>
</body>
</html>