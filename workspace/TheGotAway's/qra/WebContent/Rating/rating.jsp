<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/css/rating/rating.css" rel="stylesheet">
<style type="text/css">
.rheader {
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
</style>
</head>
<body>
<jsp:include page="/myPage/top.jsp"></jsp:include>
<div class="rheader">
<h1 class="p_title">등급</h1>

<div class ="p_head">
	<div class="p_nav1">
		<p>현재 나의 등급</p>
		<h1>Gold</h1>
		<p class="ppp1"> 유지기간 | 3개월/매월 10일 변경</p>
		<p class="ppp2"> 산정기간 | 최근 6개월/ 2017-10-01 - 2018-03-30</p>
	</div>

	
	<div class="p_nav2">
		<ul class="p_nav_ul1">
			<li>포인트 이용안내</li>
		</ul>
			<ul class="p_nav_ul2">
			<li>최근 8개월간 1일 ~ 말일까지의 구매건수(일 개수 기준)와 구매금액을 합산하여 매월 10일 등급을 부여합니다</li>
			<li>등급의 유효기간은 매 월 10일 ~ 익 월 9일까지이며 각 등급별 혜택은 당사 사정에 따라 변경 되 수 있습니다.</li>
			<li>각 등급별 혜택은 당사 사정에 따라 변경 될 수 있습니다.</li>
			</ul>
	</div>
</div>


</div>


</body>
</html>