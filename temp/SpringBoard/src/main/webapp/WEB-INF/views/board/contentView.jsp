<%@page import="board.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>contentView</h4>
<hr>
<div>title: ${board.title }</div>
<div>content: ${board.content }</div>
<div>hit: ${board.hit }</div>
<div>recommend: ${board.recommend }</div>
<div>writtenDate: ${board.writtenDate }</div>
<div>boardNo: ${board.boardNo }</div>
<div style="text-align: center;">
<a href='list'><button value="list">list</button></a>
<%String writerId = ( (Board)request.getAttribute("board") ).getWriterId();
if( session.getAttribute("id")!=null && writerId!=null && session.getAttribute("id").equals(writerId) ){%>
	<a href='delete?boardNo=${board.boardNo }&writerId=${board.writerId }'><button value="delete">delete</button></a>
	<a href='edit?boardNo=${board.boardNo }&writerId=${board.writerId }'><button value="edit">edit</button></a>
<%}else{%>
<%}%>

<%if( (Board)request.getAttribute("recBoard")==null ){%>
	<a href='recommend?boardNo=${board.boardNo }'><button value ="recommend">recommend</button></a>
<%}else{%>
	<a href='undoRecommend?boardNo=${board.boardNo }'><button value ="undo Recommend">undo Recommend</button></a>	
<%}%>

</div>
</body>
</html>