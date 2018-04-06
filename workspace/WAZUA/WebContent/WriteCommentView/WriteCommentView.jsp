<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="moviePage.dto.Pack"%>
<%@page import="moviePage.dto.entities.Entity"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	windows.onload=function(){
		document.getElementById('cancelbtn').onclick=function(){
			window.location='<%=application.getInitParameter("Address")+application.getContextPath()+application.getInitParameter("MoviePage")+"?movie="+(String)(request.getAttribute("mvIdx"))%>';
		}
	}
</script>
<body>
<%

Pack pack = (Pack)request.getAttribute("pack");
//============================== print pack ==================================================

for(String key : pack.getKeys()) { %>
	<Div><%=key %>
	<% for(Entity e :pack.getList(key)){ %>
		<div>
			Properties: <%= e.getPropertiesTable() %>
		</div>
		<div>
			Images: <%= e.getImgsTable()%>
		</div>
	<% }%>
	</Div>
	<hr><br>
<%}
%>
<hr><br>
<%

//================================================================================

ArrayList<Entity> movList = pack.getList("MOVIE");
ArrayList<Entity> accList = pack.getList("ACCOUNT");
Entity movie = null ;
Entity account = null;
String propHolder=null, propHolder2=null;
ArrayList<String> imgListHolder = null;





if(movList!=null&&accList!=null){
	for(Entity movies: movList){
		if(movies.getIdx().matches((String)request.getAttribute("mvIdx"))){
			movie = movies;
			break;
		}
	}
	for(Entity accounts: accList){
		if(accounts.getIdx().matches((String)session.getAttribute("id"))){
			account = accounts;
			break;
		}
	}
	if(movie!=null&&account!=null){
		
		//ENGTITLE + KORTITLE
				propHolder = movie.getProperty("ENGTITLE");
				propHolder2 = movie.getProperty("KORTITLE");
				if(propHolder!=null){
					%><div id = MovieTitle><h4><%=propHolder%> (<%=propHolder2%>)</h4></div><%
				}else{
					if(propHolder2!=null){
						%><div id = MovieTitle><h4><%=propHolder2%></h4></div><%
					}else{
						%><div id = MovieTitle><h4>No MovieTItle found</h4></div><%
					}
				}
		
		//poster???? maybe something else later.
		imgListHolder= movie.getImgs("thumb");
		propHolder = (String)application.getAttribute("Nullthumb");
		if(imgListHolder!=null){
			%><div id = Moviethumb><img src ='<%=imgListHolder.get(0)%>'></div><%
		}else if(propHolder!=null){
			%><div id = Moviethumb><img src ='<%=propHolder%>'></div><%
		}else{
			System.out.println("movie thumb null!");//------------------------------------------test
			%><div id = Moviethumb><h4>Sorry, found no thumbnail</h4></div><%
		}
		
		//SCORE
		propHolder = account.getProperty("SCORE");
		if(propHolder!=null){
			%>
			<div id='SCORE'>
			<p id='SCORE Ptag'>Your Score: <%=propHolder%></p>
			</div>
			<%
		}else{
			%>
			<div id='SCORE'>
			<p id='SCORE Ptag'>Your Score: </p>
			</div>
			<%
		}
		
		%>
		<div id='formdiv'>
			<form action="<%=application.getContextPath()+application.getInitParameter("WriteComment")%>"id='form'method='post'>
				<textarea rows="60"cols="30"name='comment'></textarea><br>
				<input type='hidden'name='mvIdx'value='<%=(String)request.getAttribute("mvIdx")%>'>
				<p>점수를 입력하세요</p>
				<input type='number'name='score'min='0'max='<%=application.getInitParameter("MaxScore")%>'step='0.1'>
				<input type='button'id='cancelbtn'value='Cancel'>
				<input type='submit'value='Commit!'>
			</form>
		</div>
		<%
		
	}else{
		%>
		<div>
		<h2>Oops!sorry, Something's wrong here.</h2>
		</div>
		<%
	}
}else{
	%>
	<div>
	<h2>Oops!sorry, Something's wrong here.</h2>
	</div>
	<%
}





%>
</body>
</html>