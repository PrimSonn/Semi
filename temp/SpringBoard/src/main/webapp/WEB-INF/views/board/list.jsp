<%@page import="board.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
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
		<th><a href='view?boardNo=<%=board.getBoardNo()%>'><%=board.getTitle() %></a></th>
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
<a href='Sign/Main'><button>Main</button></a>

<br>
<form action='list' method='post'>
	<input type='text' name='title'>
	<input type='hidden' name='curPage' value=''>	<!-- Paging connect required -->
	<button type='submit' value='search'>search title</button>
</form>

</div>

</body>
</html>