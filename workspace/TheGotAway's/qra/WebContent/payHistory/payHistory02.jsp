<%@page import="myPage.dto.PayHistoryDto"%>
<%@page import="myPage.dao.PayHistoryDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.pheader {
	margin: 0 auto;
	max-height: 1024px;
	max-width: 1024px; 
	min-height: 1024px;
	min-width: 1024px;
	text-align: center;
}
.p_title{
	border-bottom: 1px solid gray;
	text-align: left;
	padding-bottom: 30px;
	margin-bottom: 30px;
	margin-top: 40px;
}
.p_body1{
	
	border: 1px solid gray;
		
	width: 1024px;
	padding-top: 10px;
	padding-bottom: 10px;
}
.p_body2{
	border-bottom: 1px solid gray;
	
	width: 1024px;
	padding-top: 10px;
	padding-bottom: 10px;
}
.item1{
	width: 150px;
}
.item2{
	border-left: 1px solid gray;
	border-right: 1px solid gray;
	width: 550px;
}
.item3{ 
	border-right: 1px solid gray;
	width: 100px;
}
.item4{
	width: 100px;
}
.item5{
	width: 150px;
}
.item6{
	width: 550px;
}
.item7{
	width: 100px;
	color: red;
}
.item8{
	width: 100px;
}
select{
	height: 23px;
}
.paynav{
	text-align: left;
	margin-bottom: 20px;
}
.paynav a:link {
	color: black;
	text-decoration: none;
}
.a1{
	font-weight: bold;
}
.paynav a:visited {
	color: black;
}

</style>
</head>
<body>
 <jsp:include page="/myPage/top.jsp"></jsp:include> 

<div class= "pheader">
	<h1 class="p_title">결제 내역</h1>
	
	
<div class="paynav">
	<a href ="/payHistory/payHistory01.jsp" >결제내역</a> | <a href ="/payHistory/payHistory02.jsp" class ="a1" >취소내역</a>
</div>	
<table class="p_body1">
	<tr >
		<td class ="item1">날짜</td>
		<td class ="item2">내역</td>
		<td class ="item3">받은적립금</td>
		<td class ="item4">사용적립금</td>
	</tr>
</table>
<%
	PayHistoryDao paydao = new  PayHistoryDao();
	ArrayList<PayHistoryDto> dtos = paydao.payreset();

	for(int i =0; i<dtos.size(); i++){
		PayHistoryDto dto = dtos.get(i);
	
%>
<table class="p_body2">
	<tr>
		<td class="item5"><%=dto.getP_date() %></td>
		<td class="item6"><%=dto.getMethod() %></td>
		<td class="item7"><%=dto.getPay() %></td>
		<td class ="item8">상태</td>
	</tr>
</table>
<%} %>
<form action="/dcl/PayHistorySearch" method="get">
	<select name="gk">
		<option value="전체">전체</option>
	</select>
	<input type="text"  name="title">
	
	<input type="button" value ="검색" > 
</form>	
</div>
</body>
</html>