<%@page import="myPage.dao.QraDao"%>
<%@page import="myPage.dto.QraDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%> 
    
<%!
QraDto dto;

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="/css/qra/qra.css" rel="stylesheet">
<style type="text/css">
.c_title{
	border-bottom: 1px solid gray;
	text-align: left;
	padding-bottom: 30px;
	margin-bottom: 30px;
	margin-top: 40px;
}
</style>
<script>

	
  $( function() {
    $( "#accordion" ).accordion({
      collapsible: true
	});
  } );

  </script>


</head>
<body>
 <jsp:include page="/myPage/top.jsp"></jsp:include> 
 <div class="qheader">
 
 <h1 class="c_title">문의내역</h1>
 
<div>

<table class="qhead1">
	<tr >
	<td class="item1">문의유형</td>
	<td class="item2">제목</td>
	<td class="item3">문의날짜</td>
	<td class="item4">답변상태</td>
	</tr>
</table>


<div id="accordion">
<%
	QraDao qraDao = new QraDao();
	ArrayList<QraDto> dtos = qraDao.qra();
	
	for(int i=0; i<dtos.size(); i++){
		dto = dtos.get(i);

%>
  
  <table class="qhead2">
	<tr>
		<td class="item5"><%=dto.getQ_type() %></td>
		<td class="item6"><%=dto.getQ_title() %></td>
		<td class="item7"><%=dto.getQ_date() %></td>
		<td class="item8"><%=dto.getStatus() %></td>
	</tr>
		
</table>
	<div class="qna">
	<ul class="nav">
		<li class="q"><img src="../img/Q.png"></li>
		<p class = "ctnt"><%=dto.getQ_ctnt() %></p><hr>
	 	<li class="a"><img src="../img/A.png"></li>
 		<p class = "ctnt"><%=dto.getA_ctnt() %></p>
 		<li class="ad"><%=dto.getA_date() %></li>
	</ul>
	<br>		
</div>


<%} %>
</div>


</div>

<form action="/dcl/QraSearch" method="post">
	<select name="gk">
		<option value="전체">전체</option>
		<option value="삼품문의">상품문의</option>
		<option value="취소/환불">취소/환불</option>
		<option value="제휴문의">제휴문의</option>
		<option value="고객제안">고객제안</option>
		<option value="기타">기타</option>
	</select>
	<input type="text"  name="title">
	
	<input type="button" id ="getResult" value ="검색" > 
</form>	

</div>
</body>
</html>