<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
	function deleteAct(idx){
// 		console.log("deleteAct at: "+idx);
// 		location.href="/web/member/delete?idx="+idx;

		/*
		var form = document.createElement('form');
		form.method='post';
		form.action='/web/member/delete'
		
		var idxInput = document.createElement('input');
		idxInput.type='hidden';
		idxInput.name='idx';
		idxInput.value=idx;
		
		form.appendChild(idxInput);
		document.body.appendChild(form);
		
		form.submit();
		*/
		
		var $form = $("<form>").attr({ action:"/web/member/delete.", method:"post" });
		var $input = $("<input>").attr({ type:"hidden" , name: "idx" , value: idx });
		
		$form.append( $input );
		$(document.body).append( $form );
		
		//---------------------------------------------------------
		
		/*
		var $form = null;	
		$(document.body).append(
			$form = $("<form>").attr({
				action:"/web/member/delete", method:"post"
			}).appned(
				$("<input>").attr({
					type:"hidden", name: "idx", value: idx}
				})
			)
		);
		*/
		
		$form.submit();
	}
	$(document).ready(function(){
		$(".updateBtn").click(function(){
			
			var id = $(this).attr("id");
			
// 			console.log($(this));
			
// 			$.ajax({
// 				type: "post"
// 				,url: "update"
// 				,data:{
// 					idx: $(this).attr("id")
// 					,name: $("#name").val()
// 					,email: $("#email").val()
// 					,phone: $("#phone").val()
// 				}
// 				, dataType: "json"
// 				//, dataType: "Html"
// 				, success: function( response ){
// // 					$(location).attr("href", "main");
// // 					locatino.href="main";
// 					$("#tr"+id).css("color","red");
					
// // 					$("#tr"+id+" td").eq(1).html($("#name").val());
// // 					$("#tr"+id+" td").eq(2).html($("#email").val());
// // 					$("#tr"+id+" td").eq(3).html($("#phone").val());
					
// 					$("#tr"+id+" td").eq(1).html(response.name);
// 					$("#tr"+id+" td").eq(2).html(response.email);
// 					$("#tr"+id+" td").eq(3).html(response.phone);

// 				}
// 				, error: function(){
// 					alert("Ajax communication failed!");
// 				}
// 			});
			
			$.ajax({
				type: "post"
				, url: "update"
				, data: {
					idx: $(this).attr("id")
					, name: $("#name").val()
					, email: $("#email").val()
					, phone: $("#phone").val()
				}
				, dataType: "html"
				, success: function( d ) {
					alert("AJAX 통신 성공(정상적인 응답)");
					console.log(d);
					$("#tr"+id).html(d);
				}
				, error: function() {
					alert("AJAX 통신 실패(비정상적인 응답)");
				}
			});
			
		});
	});
</script>
</head>
<body>

<div>

<h1>멤버 메인</h1>
<hr>

<form action="/web/member/insert" method="post">
	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text"name="name"id="name"></td>
				<td><input type="text"name="email"id="email"></td>
				<td><input type="text"name="phone"id="phone"></td>
				<td><input type="submit"value="singUp"></td>
			</tr>
		</tbody>
	</table>
</form>
<hr><br>
<c:if test="${list.size() eq 0 }">
	<h3>No data found</h3>
</c:if>
<c:if test="${list.size() ne 0 }">
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>가입날짜</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach items="${list }" var="data">
			<tr id="tr${data.idx }">
				<td>${data.idx }</td>
				<td>${data.name }</td>
				<td>${data.email }</td>
				<td>${data.phone }</td>
				<td><fmt:formatDate value="${data.joinDate }" pattern="yyyy-MM-dd"/></td>
				<td>
					<button class="updateBtn" id="${data.idx}">수정</button>
					<button onclick="deleteAct(${data.idx});">삭제</button>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>

</div>

</body>
</html>








