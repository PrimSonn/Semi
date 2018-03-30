<%@page import="dto.WishListDto"%>
<%@page import="dao.WishListDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.qheader {
	margin: 0 auto;
	max-height: 1024px;
	max-width: 1024px; 
	min-height: 1024px;
	min-width: 1024px;
	text-align: center;
}
.mlist{
	display:inline-block;
	float:left;
	padding-right: 10px; 
	margin:0;
	margin-top: 20px;
	width: 246px;
}

hr{
	width: 1024px;
}
.htitle{
	
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
 <div class="qheader">
<h1 class= "htitle">시청 내역</h1>

<%
	WishListDao  dao = new WishListDao();
	ArrayList<WishListDto> dtos = dao.wish();
	
	for(int i =0; i<dtos.size(); i++){
		WishListDto dto = dtos.get(i);	
	
			
%>


	<p class="mlist"><a href ="/playHistory/m.jsp"><img src="../img/cat.jpg" width="250px" height="300px" ></a></p>

	
	

<%} %>
</div>
</body>
</html>