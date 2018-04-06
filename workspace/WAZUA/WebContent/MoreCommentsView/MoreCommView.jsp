<%@page import="java.util.ArrayList"%>
<%@page import="moviePage.dto.entities.Entity"%>
<%@page import="moviePage.dto.Pack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String contextPath = application.getContextPath();
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
	<br><hr><br><hr><br>
<%}

//================================================================================


ArrayList<Entity> movList = pack.getList("MOVIE");
ArrayList<Entity> accList = pack.getList("ACCOUNT");
ArrayList<String> imgListHolder = null;
String propHolder=null, propHolder2=null;
Entity movie=null;

if(movList!=null){
	for(Entity movies: movList){
		if(movies.getIdx().matches((String)request.getAttribute("mvIdx"))){
			movie = movies;
			break;
		}
	}
	if(movie!=null){
		//poster
		imgListHolder= movie.getImgs("poster");
		propHolder = (String)application.getAttribute("Nullposter");
		if(imgListHolder!=null){
			%><div id = MoviePoster><img src ='<%=imgListHolder.get(0)%>'></div><%
		}else if(propHolder!=null){
			%><div id = MoviePoster><img src ='<%=propHolder%>'></div><%
		}else{
			System.out.println("movie poster null!");//------------------------------------------test
			%><div id = MoviePoster><h4>Sorry, no poster found</h4></div><%
		}
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
		%><hr><h4>댓글목록</h4><%
		
		if(accList!=null){
			for(Entity comEnt: accList){//listing comments
				
				////show commenter's thumbnail
				if(comEnt.getImgs("thumb")!=null){
					propHolder=comEnt.getImgs("thumb").get(0);
					propHolder2=(String)application.getAttribute("Nullthumb");
					%>
					<div id='Comment Thumb'><img src='<%=propHolder%>'/></div>
					<%
				}else if(propHolder2!=null){//when there's no thumbnail on this guy.
					%>
					<div id='Comment Thumb'><img src='<%=propHolder2%>'/></div>
					<%
				}else{//no thumbnail, no contextAttribute thumbnail ready
					%>
					<div id='Comment Thumb'></div>
					<%
				}//show commenter's thumbnail ends
				
				//show commenter's name
				propHolder = comEnt.getProperty("NAME");
				if(propHolder!=null){
					%>
					<div id='Comment Name'><%=propHolder%></div>
					<%
				}else{//when there's no name on this guy.
					%>
					<div id='Comment Name'></div>
					<%
				}//show commenter's name ends
				
				//commenter's score
				//-----------------
				
				//comment's SCORE
				propHolder = comEnt.getProperty("SCORE");
				if(propHolder!=null){
					%>
					<div id='Comment Score'><%=propHolder%></div>
					<%
				}else{//when there's no name on this guy.
					%>
					<div id='Comment Score'></div>
					<%
				}//show commenter's name end
				
				
				//comment's REGDATE
				propHolder = comEnt.getProperty("REGDATE");
				if(propHolder!=null){
					%>
					<div id='Comment Regdate'><%=propHolder%></div>
					<%
				}else{//when there's no name on this guy.
					%>
					<div id='Comment Regdate'></div>
					<%
				}//show commenter's name end
				
				//comment contents
				propHolder = comEnt.getProperty("CONTENTS");
				if(propHolder!=null){
					%>
					<div id='Comment Contents'><%=propHolder%></div>
					<%
				}else{//when there's no name on this guy.
					%>
					<div id='Comment Contents'></div>
					<%
				}//comment contents end
				
			}//comment listing for ends
			
			int pageNum =(int)request.getAttribute("pageNumber");
			int commNum =(int)request.getAttribute("COMMCOUNT");
			
			
			
			
			
			
		}else{
			//no comment found?
		}
	}else{
		System.err.println("no match movie");
		%>
		<div>
		<h2>Oops!sorry, can't find that movie.</h2>
		<a href='<%=contextPath+application.getInitParameter("Main")%>'>Go back to main page</a>
		</div>
		<%
	}
}else{
	%>
	<div>
	<h2>Oops!sorry, No movie found.</h2>
	<a href='<%=contextPath+application.getInitParameter("Main")%>'>Go back to main page</a>
	</div>
	<%
}

%>




</body>
</html>