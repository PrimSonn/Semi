<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

// 	function post(id,pw,pw2){
		
// 		var http = new XMLHttpRequest();
// 		var url = "/LogTest/SignUp";
// 		var params = 'id='+id+'&pw='+pw+'&pw2='+pw2;
		
// 		http.open("POST", url, true);
// 		http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
// 		http.onreadystatechange = function() {
// 		    if(http.readyState == 4 && http.status == 200) {
// 		        alert(http.responseText);
// 		    }
// 		}
		
// 		http.send(params);
// 	}
	
	window.onload = function(){ 
		
		document.getElementById("signUp").onclick = function() {
			
			var id = document.getElementById("id").value;
			var pw = document.getElementById("pw").value;
			var pw2 = document.getElementById("pw2").value;
			
			if(""==id||""==pw||""==pw2){
				alert("Fill out all forms");
			} else if (pw!=pw2){
				alert("check your password")
			} else {
// 				post(id,pw,pw2);
			}
		}
	}
	
</script>
</head>
<body>
<!-- 	<div> -->
<!-- 		ID: <input type="text" id="id" name="id" /><br> -->
<!-- 		PW: <input type="text" id="pw" name="pw" /><br> -->
<!-- 		PW2: <input type="text" id="pw2" name="pw2" /><br> -->
<!-- 		<hr><button id='signUp'>SignUp</button> -->
<!-- 	</div> -->
	<form action='/LogTest/SignUp' method='post'>
	ID: <input type='text' name='id'><br>
	PW: <input type='text' name='pw'><br>
	PW2: <input type='text' name='pw2'><br>
	<input type='submit' value='Submit'>
	</form> 
</body>
</html>