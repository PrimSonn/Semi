<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="moviePage.dto.Pack"%>
<%@page import="moviePage.dto.entities.Entity"%>
<%
String contextPath = application.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Pack pack = (Pack)request.getAttribute("pack");
//============================== print pack ==================================================
/*
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
*/
//================================================================================

ArrayList<Entity> movList = pack.getList("MOVIE");
ArrayList<Entity> accList = pack.getList("ACCOUNT");
Entity movie = null ;
Entity account = null;
String propHolder=null, propHolder2=null, propHolder3=null;
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
			<p id='SCORE Ptag'>Score you gave: <%=propHolder%></p>
			</div>
			<%
		}else{
			%>
			<div id='SCORE'>
			<p id='SCORE Ptag'>Your Score: </p>
			</div>
			<%
		}
		
		propHolder = account.getProperty("COMMIDX");
		propHolder2 = account.getProperty("CONTENTS");
		propHolder3 = request.getParameter("page");
		boolean isEdit = (propHolder!=null&&propHolder2!=null&&propHolder!=""&propHolder2!="");
		%>
		<div id='formdiv'>
			<form action="<%=application.getContextPath()+application.getInitParameter("WriteComment")%>"id='form'method='post'>
				<textarea rows="20"cols="130"name='comment'><%if(isEdit)out.print(propHolder2);%></textarea><br>
				<input type='hidden'name='mvIdx'value='<%=(String)request.getAttribute("mvIdx")%>'>
				<%if(isEdit)
					%><input type='hidden'name='commIdx'value='<%=propHolder%>'><%
					;%>
				<p>(선택)점수를 입력하세요(0~<%=application.getInitParameter("MaxScore")%>)</p>
				<%
				if(propHolder3!=null&&propHolder3!="")
				%>
				<input type='hidden'name='page'value='<%=propHolder3%>'/>
				<%; %>
				<input type='number'name='score'min='0'max='<%=application.getInitParameter("MaxScore")%>'step='0.1'>
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