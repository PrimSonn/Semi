<%@page import="myPage.dao.PointDao"%>
<%@page import="myPage.dto.Point_bd_Dto"%>
<%@page import="myPage.dto.PointDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
PointDto pdto;
Point_bd_Dto pbd;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/css/point/point.css" rel="stylesheet">
<style type="text/css">
.p_title{
	border-bottom: 1px solid gray;
	text-align: left;
	padding-bottom: 30px;
	margin-bottom: 30px;
	margin-top: 40px;
}
</style>
</head>
<body>
<jsp:include page="/myPage/top.jsp"></jsp:include>
<div class="pheader">
<h1 class="p_title">나의 포인트</h1>
<%
	PointDao pdao = new PointDao();
	ArrayList<PointDto> dtos1 = pdao.retpdao();
	
		 pdto = dtos1.get(0);
%>

<div class ="p_head">
	<div class="p_nav1">
		<p>현재 보유 포인트</p>
		<h1><%=pdto.getPoint() %></h1>
		<h3>Point</h3>
	</div>

	<div class="p_nav2">
		<ul>
			<li>포인트는 상품 구매시 현금처럼 사용할 수 있습니다.</li>
			<li>포인트는 본인만 사용 가능하며 타인에게 양도할 수 없습니다.</li>
			<li>포인트는 환급되지 않으며 탈퇴시 자동으로 소멸됩니다.</li>
			<li>포인트는 유효기간(2년)으로 인하여 적립된 금액과 사용가능 금액이 다를 수 있습니다.</li>
		</ul>
	</div>
</div>


<table class="p_body1">
	<tr >
		<td class ="item1">날짜</td>
		<td class ="item2">내역</td>
		<td class ="item3">받은적립금</td>
		<td class ="item4">사용적립금</td>
		<td class ="item5"> 상태</td>
		
	</tr>
</table>

<%
	PointDao pbddao = new PointDao();
	ArrayList<Point_bd_Dto> dtos2 = (ArrayList)request.getAttribute("search");
	for(int i = 0; i<dtos2.size(); i++){
		pbd = dtos2.get(i);
%>

<table class="p_body2">
<tr >
		<td class="item6"><%=pbd.getCng_date() %></td>
		<td class="item7"><%=pbd.getCng_cus() %></td>
		<td class="item8"><%=pbd.getRec_pnt() %></td>
		<td class ="item9"><%=pbd.getUse_pnt() %></td>
		<td class ="item10"> <%=pbd.getStatus() %></td>
	</tr>
</table>
<%} %>
<form action="/dcl/PointSearch" method="get">
	<select name="gk">
		<option value="전체">전체</option>
	</select>
	<input type="text"  name="title">
	
	<input type="button" value ="검색" > 
</form>	
</div>

</body>
</html>