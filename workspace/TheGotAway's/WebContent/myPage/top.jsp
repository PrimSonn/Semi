<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>와즈아 - 마이페이지</title>

<link rel="shortcut icon" type="image/png" href="logo.png" />
<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link href='//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/star.css" rel="stylesheet">
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script type="text/javascript" src="../js/star.js"></script>
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
	box-sizing: border-box;
}

body {
	font-family: 'Nanum Gothic';
	font-size: 30px;
	line-height: 1.8;
}

.wrapper {
	border: 1px solid #000;
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


  


.mainmenu { display: inline-block; height: 70px; float: left; }
.mainmenu #home { display: inline-block;}
.mainmenu  ul { display: inline-block; overflow: hidden; list-style: none; vertical-align: middle; margin-bottom: 0; }
.mainmenu  ul  li {  float: left; }
.mainmenu  ul:first-child li { margin: 10px 0; }
.mainmenu  ul  li  a {
	text-align: center;
	vertical-align: middle;
	text-decoration: none;
	font-size: 15px;
	font-weight: bold;
	display: block;
	padding: 2px 10px;
	line-height: 30px;
	
}

.mainmenu ul ul {
	display: none;
	position: absolute;
	background-color: yellow;
	z-index: 9999;
}

.mainmenu ul li:hover ul {
	display: block;
}

.mainmenu ul ul li {
	border: none;
	height: 30px;
	float: none;
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
}

#my_gnb > ul { position: relative; display: table; overflow: hidden; list-style: none; }

#my_gnb > ul > li { 
    list-style: none;
    float: left;
    line-height: 30px;
    vertical-align: middle;
    text-align: center; 
    font-size: 13px;
}
    
#my_gnb > ul > li > a {
	width: 128px;
	height: 58px;
	line-height: 58px;
	text-align: center;
	text-decoration: none;
	display: block;
	padding: 2px 6px;
	border-bottom: 2px solid #ccc;
}

#my_gnb > ul > li > a:link {
	color: black;
}

#my_gnb > ul > li > a:visited {
	color: black;
}

#my_gnb > ul > li > a:hover {
	width: 128px;
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
	width: 686px;
	height: 100%;
	border: 1px solid #d9d9d9;
	border-top: none;
	border-bottom: none;
}

#c_readmore {
	width: 213px;
	height: 100%;
}

.stars {
	display: inline-block;
    vertical-align: top;
    background: url('../img/star.png');
}

.rm {
	width: 100%;
	height: 50%;
	text-align: center;
}

.grade {
	padding: 32px;
}

p.read {
	margin: auto auto;
}

#c_title {
	width: 100%;
	height: 60px;
	padding: 10px 30px 8px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

#c_comment {
	width: 100%;
	height: 115px;
	padding: 12px 30px;
	overflow: scroll;
	word-break: break-all;
	font-size: 15px;
	font-weight: normal;
	color: black;
	line-height: 1.5em;
}

.clear {
	clear: both;
	height: 0px;
	overflow: hidden;
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
					<li><a href="#">카테고리</a>
						<ul>
							<li><a href="#">카테고리1</a></li>
							<li><a href="#">카테고리2</a></li>
							<li><a href="#">카테고리3</a></li>
						</ul></li>
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
		<nav id="my_gnb" style="width:1024px; height:65px;">
			<ul>
				<li><a href="#">Payment History</a></li>
				<li><a href="#">My Point</a></li>
				<li><a href="#">Favorite</a></li>
				<li><a href="#">Comment</a></li>
				<li><a href="#">Interest Movies</a></li>
				<li><a href="#">History Watched</a></li>
				<li><a href="#">Contact Details</a></li>
				<li><a href="#">Rating Guide</a></li>
			</ul>
		</nav>
		<div class="content">
			<div class="Title" style="font-size:24px; color:#8c8c8c; font-weight: bold;">
				<br/>
				COMMENT
				<br/>
				<div style="font-size:8px;">
					<hr color="#ccc" style="margin: 20px 0 40px;">
				</div>
				<div class="comments">
					<div class="c_box">
						<div class="comm" id="c_poster"><img src="http://via.placeholder.com/123x175"></div>
						<div class="comm" id="c_content">
							<div id="c_title"><span style="font-size:20px; color:black; margin-right:30px;">매트릭스</span><span style="font-size:14px; color:#ccc;">2099.12.31</span></div>
							<div id="c_comment">
								2199년. 인공 두뇌를 가진 컴퓨터(AI: Artificial Intelligence)가 지배하는 세계. 인간들은 태어나자마자 그들이 만들어낸 인공 자궁 안에 갇혀 AI의 생명 연장을 위한 에너지로 사용되고 AI에 의해 뇌세포에 매트릭스라는 프로그램을 입력 당한다. 내용은 1999년의 가상 현실. 인간들은 매트릭스의 프로그램에 따라 평생 1999년의 가상 현실을 살아간다. 프로그램 안에 있는 동안 인간의 뇌는 AI의 철저한 통제를 받는다. 인간이 보고 느끼는 것들은 항상 그들의 검색 엔진에 노출되어 있고, 인간의 기억 또한 그들에 의해 입력되고 삭제된다. 

가상 현실 속에서 진정한 현실을 인식할 수 있는 인간은 없다. 꿈에서 깨어난 자들, 그들이 세상을 지배한다. 매트릭스 밖.... 가상 현실의 꿈에서 깨어난 유일한 인간들이 생존해 있는 곳. 그곳엔 AI에게 인류 역사상 가장 위험한 인간으로 알려진 모피어스와 그와 더불어 AI에 맞서 싸우는 동료들이 있다. 그들은 광케이블을 통해 매트릭스에 침투하고 매트릭스 프로그램을 응용해 자신들의 뇌 세포에 각종 데이터를 입력한다. 그들의 당면 목표는 인류를 구원할 영웅 그(The One)를 찾아 내는 것. 그들은 AI통제 요원들의 삼엄한 검색 망을 뚫고 매트릭스 안에 들어가 드디어 오랫동안 찾아 헤매던 "그"를 발견한다. "그"는 유능한 컴퓨터 프로그래머, 토마스 앤더슨. 낮에는 평범한 회사원으로 살아가지만, 밤마다 "네오"라는 이름으로 컴퓨터 해킹에 나서는 "그"는 모피어스로부터 조심스레 매트릭스에 대한 단서를 얻는다. 인간의 기억을 지배하는 가상현실 - 매트릭스 알 수 없는 두려움 속에서 실체를 추적해 나가는 네오. 

어느 날, 매혹적인 여인 트리니티의 안내로 또 다른 숨겨진 세계 - 매트릭스 밖의 우주를 만나게 된 네오. 꿈에서 깨어나 AI에게 양육되고 있는 인간의 비참한 현실을 확인하고 매트릭스를 탈출한다. 한편, 사이퍼는 끊임없는 기계들의 위협과 공격으로 인한 두려움을 견디지 못하고, 다시 매트릭스 안의 가상 현실로 들어가기 위해 동료들을 배신한다. 네오와 모피어스 일행이 매트릭스 안에 잠입한 사이 사이퍼는 요원들이 추적할 수 있도록 '통화 중'인 폰을 숨기고, 요원들은 광케이블을 교란시켜 그들이 매트릭스에서 빠져나올 출구를 봉쇄해 버리는데...
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
				</div>
			</div>
		
		</div><!--  content end -->
	</div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>