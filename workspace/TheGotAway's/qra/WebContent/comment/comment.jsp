<%@page import="myPage.dto.commentDto"%>
<%@page import="myPage.dao.commentDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cheader {
	margin: 0 auto;
	max-height: 1024px;
	max-width: 1024px; 
	min-height: 1024px;
	min-width: 1024px;
	text-align: center;
}
.c_title{
	border-bottom: 1px solid gray;
	text-align: left;
	padding-bottom: 30px;
	margin-bottom: 30px;
	margin-top: 40px;
}

#c_title {
	width: 100%;
	height: 30px;
	padding-top:20px;
	padding-bottom:10px;
	text-align:left;
	margin-left:30px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

#c_comment {
	text-align:justify;
	width: 100%;
	height: 116px;
	overflow: auto;
	word-break: break-all;
	font-size: 15px;
	font-weight: normal;
	color: black;
	line-height: 1.5em;
}
.c_box {
	height: 177px;
	border: 1px solid #d9d9d9;
	margin: 20px auto;
}
.comm {
	display: inline-block;
	float: left;
}
#c_poster {
	width: 123px;
	height: 100%;
}

#c_content {
	width: 650px;
	height: 100%;
	border: 1px solid #d9d9d9;
	border-top: none;
	border-bottom: none;
}

#c_readmore {
	width: 144px;
	height: 100%;
}
.stars {
	display: inline-block;
    vertical-align: top;
    background: url("./star.png");
}
.cm{
	display:inline-block;
	margin-left: 30px;
	margin-right: 30px;
}
.rm {
	width: 100%;
	height: 40%;
	text-align: center;
	padding-left: 55px;
}

.grade {
	
	padding-left: 55px;
	padding-top: 35px;
}

p.read {
	margin: auto auto;
}
.star-input>.input,
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{
    display: inline-block;
    vertical-align: top;
    background: url('../img/star.png') no-repeat;
}
.star-input{
    white-space: nowrap;
}
.star-input>.input{
    display:inline-block;
    width: 140px;
    background-size: 140px;
    height: 27px;
    white-space: nowrap;
    overflow: hidden;
    position: relative;
}
.star-input>.input>input{
    position: absolute;
    width: 1px;
    height: 1px;
    opacity: 0;
}
.star-input>.input.focus{
    outline: 1px dotted #ddd;
}
.star-input>.input>label{
    width: 14px;
    height: 0;
    padding: 27px 0 0 0;
    overflow: hidden;
    float: left;
    cursor: pointer;
    position: absolute;
    margin-bottom: 0;
    top: 0;
    left: 0;
}
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{
    background-size: 140px;
    background-position: 0 bottom;
}
.star-input>.input>label:hover~label{
    background-image: none;
}
.star-input>.input>label[for="p1"]{ 
    width: 14px;
    z-index: 10;
}
.star-input>.input>label[for="p2"]{ 
    width: 28px;
    z-index: 9;
}
.star-input>.input>label[for="p3"]{ 
    width: 42px;
    z-index: 8;
}
.star-input>.input>label[for="p4"]{ 
    width: 56px;
    z-index: 7;
}
.star-input>.input>label[for="p5"]{ 
    width: 70px;
    z-index: 6;
}
.star-input>.input>label[for="p6"]{ 
    width: 84px;
    z-index: 5;
}
.star-input>.input>label[for="p7"]{ 
    width: 98px;
    z-index: 4;
}
.star-input>.input>label[for="p8"]{ 
    width: 112px;
    z-index: 3;
}
.star-input>.input>label[for="p9"]{ 
    width: 126px;
    z-index: 2;
}
.star-input>.input>label[for="p10"]{ 
    width: 140px;
    z-index: 1;
}
</style>
</head>
<jsp:include page="/myPage/top.jsp"></jsp:include>
<body>
		
<div class= "cheader">
				<h1 class="c_title">댓글</h1>
				<div class="comments">
<%
	commentDao dao = new commentDao();
	ArrayList<commentDto> dtos = dao.comm();
	
	for(int i =0; i<dtos.size(); i++){
		commentDto dto = dtos.get(i);
	
%>					
					<div class="c_box">
						<div class="comm" id="c_poster"><img src="http://via.placeholder.com/123x175"></div>
						<div class="comm" id="c_content">
							<div id="c_title"><span style="font-size:20px; color:black; margin-right:30px;"><%=dto.getC_title() %></span><span style="font-size:14px; color:#ccc;"><%=dto.getReg_date() %></span></div>
							<div id="c_comment">
								<p class="cm"><%=dto.getContent() %></p>
						
							</div>
						</div>
						<div class="comm" id="c_readmore">
							<div class="rm grade">
								<span class="star-input">
  									<span class="input">
    									<input type="radio" name="star-input" id="p1" value="1"><label for="p1">1</label>
   									 	<input type="radio" name="star-input" id="p2" value="2"><label for="p2">2</label>
    									<input type="radio" name="star-input" id="p3" value="3"><label for="p3">3</label>
    									<input type="radio" name="star-input" id="p4" value="4"><label for="p4">4</label>
    									<input type="radio" name="star-input" id="p5" value="5"><label for="p5">5</label>
    									<input type="radio" name="star-input" id="p6" value="6"><label for="p6">6</label>
    									<input type="radio" name="star-input" id="p7" value="7"><label for="p7">7</label>
    									<input type="radio" name="star-input" id="p8" value="8"><label for="p8">8</label>
    									<input type="radio" name="star-input" id="p9" value="9"><label for="p9">9</label>
    									<input type="radio" name="star-input" id="p10" value="10"><label for="p10">10</label>
  									</span>
								</span>
							</div>
							<div class="rm readmore">
								<p class="read">
              						<a href="#" class="btn btn-lg btn-default">Read more</a>
              					</p>
           					</div>
						</div>
					</div>
				<%} %>
				</div>
				
				</div>
</body>
</html>