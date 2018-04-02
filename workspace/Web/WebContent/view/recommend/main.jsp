<%@page import="dto.Recommend"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='http://code.jquery.com/jquery-2.2.4.min.js'></script>
<script>
	$(document).ready(function() {
		
		$("#btnRecommend").click(function(){
			
			if( $('#id').val()==null || $("#id").val()=="" ){
				alert("insert ID");
				return;
			}
			
			location.href="/recommend/check.do?id="+$("#id").val();
// 				$("<form>").attr("action",'/recommend/check.do').submit();
		});
		
		$("#btnAjaxRecommend").click(function(){
			
			var id=$("#id").val();
			
			if( $('#id').val()==null || $("#id").val()=="" ){
				alert("insert ID");
				return;
			}
			
			$.ajax({
					type: "POST"
					, url: "/recommend/ajaxCheck.do"
					, data: { recommendId:id }
					, dataType: "json"
					, success: function(data){
						
						console.log("done!");
// 						data = JSON.parse(data);
						console.log(data);
						console.log(data.cnt);
// 						console.log(data.list);

						var cnt = JSON.parse(data.cnt);
						var list = JSON.parse(data.ids);
// 						var list = data.ids;
						$("#recommend").val(cnt);
						
						var html = "";
						for(var i=0; i<list.length; i++) {
							html+="<strong>" + list[i].recommendId + "</strong> ";
						}
						console.log(html);
						$("#recommendList").html(html);
						
					}
					, error: function(e){
						console.log("error!!!");
						console.log("=========================");
						console.log(e.responseText);
					}
			});
		});
	});

</script>
</head>
<body>
	<h3>
		Like if you like it
	</h3>
	<hr>
	ID: <input type='text'id='id'name='id'/><br>
	Liked: <input type='text'id='recommend'size='5'value="${total}"readonly/><br>
	<button id='btnRecommend'>Like it</button>
	<button id='btnAjaxRecommend'>Do Ajax</button>
	<hr>
<%-- 	Recommend IDs: ${IDs} --%>
	<div id='recommendList'>
	<% 
		List<Recommend> list = (List)request.getAttribute("IDs");
		for (int i=0;i<list.size(); i++){
			out.print("<h5>");
			out.println(list.get(i).getRecommendId());
			out.print("</h5>");
		}
	%>
	</div>
</body>
</html>