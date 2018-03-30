<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>와쟈 - 마이페이지</title>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script type="text/javascript">

$.fn.toggleState = function(b) {
	$(this).stop().animate({
		width: b ? "200px" : "50px"
	}, 600, "easeOutElastic" );
}

$(document).ready(function() {
	var container = $(".container");
	var boxContainer = $(".search-box-container");
	var submit = $(".submit");
	var searchBox = $(".search-box");
	var response = $(".response");
	var isOpen = false;
	submit.on("mousedown", function(e) {
		e.preventDefault();
		boxContainer.toggleState(!isOpen);
		isOpen = !isOpen;
		if(!isOpen) {
			handleRequest();
		} else {
			searchBox.focus();
		}	
	});
	searchBox.keypress(function(e) {
		if(e.which === 13) {
			boxContainer.toggleState(false);
			isOpen = false;
			handleRequest();
		}
	});
	searchBox.blur(function() {
		boxContainer.toggleState(false);
		isOpen = false;
	});
	function handleRequest() {
		// You could do an ajax request here...
		var value = searchBox.val();
		searchBox.val('');
		if(value.length > 0) {
			response.text(('Searching for "' + value + '" . . .'));
			response.animate({
				opacity: 1
			}, 300).delay(2000).animate({
				opacity: 0
			}, 300);
		}
	}
});

</script>

<style type="text/css">

*{
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Nanum Gothic';
}

.wrapper {
	margin: 0 auto;
}

.header {
	width: 1024px;
	height: 70px;
	margin: 0 auto;
}

.btn-default,
.btn-default:hover,
.btn-default:focus {
  color: black;
  text-shadow: none;
 }
 
.btn-lg {
  padding: 10px 20px;
  font-weight: bold;
}


  


.mainmenu {
	display: inline-block;
	height: 70px;
	float: left; 
}
.mainmenu #home {
	display: inline-block; 
	padding-top: 15px;
}

.mainmenu  ul {
	display: inline-block; 
	list-style: none; 
	vertical-align: middle; 
	margin-bottom: 0; 
}
.mainmenu  ul  li {  
	float: left; 
}

.mainmenu  ul:first-child li {
	margin: 10px 0; 
}

.mainmenu  ul  li  a {
	text-align: center;
	vertical-align: middle;
	text-decoration: none;
	font-size: 15px;
	font-weight: bold;
	display: block;
	padding: 2px 10px;
	line-height: 30px;
	padding-bottom: 30px;
}

.mainmenu > ul > li > a:link {
	color: black;
}

.mainmenu > ul > li > a:visited {
	color: black;
}


.mini_profile {
	height: 56px;
	margin-top: 7px;
	margin-left: 50px;
	display: inline-block;
	float: right;
}

.m_prof_img {
	width: 56px;
	height: 56px;
	border-radius: 50px;
	-moz-border-radius: 50px;
	-khtml-border-radius: 50px;
	-webkit-border-radius: 50px;
	overflow: hidden;
	

}

#m_prof_img {
	width: 64px;
	height: 64px;
	position: relative;
	bottom: 8px;
	right: 13px;
	
}

.mini_profile  ul { display: inline-block; overflow: hidden; list-style: none; }
.mini_profile  ul  li {  float: left; }
.mini_profile  ul  li  a {
	height: 56px;
	text-align: center;
	vertical-align: middle;
	text-decoration: none;
	font-size: 10px;
	display: block;
	padding: 2px 10px;
	line-height: 30px;
	
}

.mini_profile ul ul {
	display: none;
	position: absolute;
	background-color: yellow;
	z-index: 9999;
}

.mini_profile ul li:hover ul {
	display: block;
}

.mini_profile ul ul li {
	width: 150px;
	height: 50px;
	font-size: 12px;
	border: none;
	float: none;
}

.mini_profile > ul > li > a:link {
	color: black;
}

.mini_profile > ul > li > a:visited {
	color: black;
}

.search {
	width: 300px;
	height: 70px;
	display: inline-block;
	float: right;
}

.search-box-container {
  display: inline-block;
  box-sizing: content-box;
  margin-top: 10px;
  height: 50px;
  width: 50px;
  float: right;
  padding: 0;
  background-color: #fff;
  border: 1px solid black;
  border-radius: 28px;
  overflow: hidden;
}
.search-box-container * {
  display: inline-block;
  margin: 0;
  height: 100%;
  padding: 5px;
  border: 0;
  outline: none;
}
.search-box {
  width: calc(100% - 50px);
  padding: 0 20px;
  float: left;
  font-size: 0.6em;
  color: black;
  background-color: #fff;
}
.submit {
  float: right;
  width: 50px;
  left: 0;
  top: 0;
  font-size: 0.6em;
  text-align: center;
  cursor: pointer;
  background-color: #fff;
}
.fa {
  display: inline !important;
  line-height: 100%;
  pointer-event: none;
  color: black;
} 

.photo {
	height: 515px;
	background-color: black;
	border: 1px solid #000;
	overflow: hidden;
	font-size: 0px;
  	letter-spacing: 0px;
  	word-spacing: 0px;
}


.pchange {
	position: absolute;
	left: 550px;
	bottom: 360px;
	font-size: 15px;
}

.profile {
	width: 1024px;
	height: 515px;
	margin-right: auto;
	margin-left: auto;
	position: relative;
}

.ab {
	position: absolute;
}

.top {
	z-index: 100;
}

.pb.center {
	width: 456px;
	margin: 0 auto;
	
}

.pgra {
	display: inline-block;
	width: 30px;
	height: 515px;
	z-index: 3;
}

.pgra.left {
	background: -moz-linear-gradient(left, rgba(0,0,0,1) 0%, rgba(0,0,0,1) 20%, rgba(0,0,0,0.63) 49%, rgba(0,0,0,0) 99%, rgba(0,0,0,0) 100%); /* FF3.6-15 */
	background: -webkit-linear-gradient(left, rgba(0,0,0,1) 0%,rgba(0,0,0,1) 20%,rgba(0,0,0,0.63) 49%,rgba(0,0,0,0) 99%,rgba(0,0,0,0) 100%); /* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to right, rgba(0,0,0,1) 0%,rgba(0,0,0,1) 20%,rgba(0,0,0,0.63) 49%,rgba(0,0,0,0) 99%,rgba(0,0,0,0) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#000000', endColorstr='#00000000',GradientType=1 ); /* IE6-9 */
}

.pgra.right {
	background: -moz-linear-gradient(left, rgba(0,0,0,0) 0%, rgba(0,0,0,0) 1%, rgba(0,0,0,0.63) 51%, rgba(0,0,0,1) 80%, rgba(0,0,0,1) 100%); /* FF3.6-15 */
	background: -webkit-linear-gradient(left, rgba(0,0,0,0) 0%,rgba(0,0,0,0) 1%,rgba(0,0,0,0.63) 51%,rgba(0,0,0,1) 80%,rgba(0,0,0,1) 100%); /* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to right, rgba(0,0,0,0) 0%,rgba(0,0,0,0) 1%,rgba(0,0,0,0.63) 51%,rgba(0,0,0,1) 80%,rgba(0,0,0,1) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00000000', endColorstr='#000000',GradientType=1 ); /* IE6-9 */
	left: 994px;
}

.poster {
	display: inline-block;
	z-index: 2;
}

.overcast {
	width: 1024px;
	height: 515px;
	background-color: black;
	opacity: 0.4;
	z-index: 4;
}

.prof_img {
	width: 234px;
	height: 234px;
	border-radius: 234px;
	-moz-border-radius: 234px;
	-khtml-border-radius: 234px;
	-webkit-border-radius: 234px;
	overflow: hidden;
	top: 70px;
	left: 395px;

}

#prof_img {
	width: 351px;
	height: 351px;
	position: relative;
	right: 52px;
	bottom: 60px;
}

#cng_icon {
	width: 32px;
	height: 32px;
	top: 170px;
	left: 650px;
}

.user_id {
	width: 100%;
	top: 320px;
	text-align: center;
}

.boxes {
	width: 100%;
	height: 5px;
	top: 412px;
}

.p_box {
	width: 150px;
	height: 4px;
	display: inline-block;
	margin: 1px;
}

#p_box1 {
	background-color: rgb(230,245,255);
}

#p_box2 {
	background-color: rgb(153,255,51);
}

#p_box3 {
	background-color: rgb(255,204,0);
}

.user_info_title {
	width: 100%;
	top: 430px;
	margin: 0 auto;
	font-size: 13px;
	text-align: center;
	color: rgb(140,140,140);
}
div.ab.top.user_info{
	margin-top: 10px;
}
.user_info {
	
	width: 100%;
	top: 445px;
	margin: 0 auto;
	font-size: 20px;
	font-weight: bold;
	text-align: center;
	color: white;
}

.p_text {
	width: 150px;
	display: inline-block;
}

.container {
	width: 1024px;
	padding: 0;
	margin: 0 auto;
	margin-top:20px;	
	border-left: 1px solid gray;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
}

#my_gnb > ul { 
	position: relative; 
	display: inline-block; 
	overflow: hidden; 
	list-style: none; 
	box-sizing: border-box;
}

#my_gnb > ul > li { 
    list-style: none;
    float: left;
    line-height: 30px;
    vertical-align: middle;
    text-align: center; 
    font-size: 13px;
   
}
    
#my_gnb > ul > li > a {
	width: 115px;
	height: 58px;
	line-height: 58px;
	text-align: center;
	text-decoration: none;
	display: block;
	padding: 2px 6px;
	border-right: 1px solid gray;
}

#my_gnb > ul > li > a:link {
	color: black;
}

#my_gnb > ul > li > a:visited {
	color: black;
}

#my_gnb > ul > li > a:hover {
	width: 115px;
	height: 58px;
	line-height: 58px;
	text-align: center;
	text-decoration: none;
	display: block;
	padding: 2px 6px;
	font-size: 14px;
	font-weight: bold;
	background-color: black;
	color: white;
	border-bottom: 2px solid red; 
}

#my_gnb > ul > li > a:active {
	color: yellow;
}

.clear {
	clear: both;
	height: 0px;
	overflow: hidden;
}

h3{
	padding-top:15px;
	margin: 0;
}


</style>
</head>
<body>
<div class="wrapper">
		<div class="header">
			<div class="mainmenu">
				<div id="home"><a href="#"><img src="../img/logo.png"></a></div>
				<ul class="menu">
					<li><a href="#">최신영화</a></li>
					<li><a href="#">추천영화</a></li>
					<li><a href="#">카테고리</a></li>
				</ul>
			</div>
			<div class="mini_profile">
				<ul id="m_prof_ct">
					<li><div class="m_prof_img"><a href="#"><img id="m_prof_img" src="http://via.placeholder.com/64x64"></a></div>
						<ul>
							<li>1ㄱㄱㄱㄱㄱㄱㄱ</li>
							<li>2ㄴㄴㄴㄴㄴㄴㄴ</li>
							<li>3ㄷㄷㄷㄷㄷㄷㄷ</li>
							<li>4ㄹㄹㄹㄹㄹㄹㄹ</li>
							<li>5ㅁㅁㅁㅁㅁㅁㅁ</li>
							<li>6ㅂㅂㅂㅂㅂㅂㅂ</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="search">
  				<div class='search-box-container'>
    				<button class='submit'>
     					<i class='fa fa-search'></i>
   					</button>
    				<input class='search-box'>
 				</div>
			</div>
		</div>
		<div class="photo">
		<div class="center" id="pcenter">
			<div class="profile">
				<div class="ab pgra left"></div>
				<div class="ab pgra right"></div>
				<div class="ab poster"><img style="width:1024px;" src="../img/poster.jpg"></div>
				<div class="ab overcast"></div>
				<div class="ab top prof_img"><img id="prof_img" src="http://via.placeholder.com/351x351"></div>
				<img class="ab top" id="cng_icon" src="../img/cng_icon.png">
				<div class="ab top user_id"><p id="user_id" style="font-size:24px; font-weight: bold; color:white;">#USER_ID</p></div>
				<div class="ab top boxes"><div class="pb center"><div class="p_box" id="p_box1"></div><div class="p_box" id="p_box2"></div><div class="p_box" id="p_box3"></div></div></div>
				<div class="ab top user_info_title"><div class="p_text">RATING</div><div class="p_text">FAVORITE</div><div class="p_text">POINT</div></div>
				<div class="ab top user_info"><div class="p_text">Gold</div><div class="p_text">789</div><div class="p_text">12,345</div></div>
			</div>
		</div>
	</div>
	<div class="container">
		<nav id="my_gnb" style="width:1024px; height:62px;">
			<ul >
				<li><a href="/payHistory/payHistory01.jsp">결제 내역</a></li>
				<li><a href="/myPoint/myPoint.jsp">나의 포인트</a></li>
				<li><a href="/wishList/wishList.jsp">찜</a></li>
				<li><a href="/comment/comment.jsp">댓글</a></li>
				<li><a href="#">관심 영화</a></li>
				<li><a href="/playHistory/playHistory.jsp">시청 내역</a></li>
				<li><a href="/qra/qra.jsp">문의 내역</a></li>
				<li><a href="/Rating/rating.jsp">등급 안내</a></li>
			</ul>
		</nav>

</div>
</div>
</body>

</html>