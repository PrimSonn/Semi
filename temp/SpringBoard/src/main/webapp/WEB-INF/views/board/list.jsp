<%@page import="board.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%
List<Board> list = (List<Board>)request.getAttribute("list");
if(list!=null){ %>
<table class="table" border='1'>
	<thead>
		<tr>
			<th>BoardNo</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Hit</th>
			<th>Recommend</th>
			<th>WrittenDate</th>
		</tr>
	</thead>
	<%for(Board board: list){%>
<tbody>
	<tr>
		<th><%=board.getBoardNo() %></th>
		<th><%=board.getTitle() %></th>
		<th><%=board.getWriter() %></th>
		<th><%=board.getHit() %></th>
		<th><%=board.getRecommend() %></th>
		<th><%=board.getWrittenDate() %></th>
	</tr>
</tbody><%
	}//for ends%>
</table>
<%}// if ends%>

<jsp:include page="../util/paging.jsp"/>

<a href='write'><button>write</button></a>
</div>
</body>
</html>