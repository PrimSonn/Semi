<%@page import="java.util.ArrayList"%>
<%@page import="moviePage.dto.entities.Entity"%>
<%@page import="moviePage.dto.Pack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = application.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){ 
		document.getElementById("WriteComment").onclick = function(){
			var form = document.createElement('form');
			form.setAttribute('method', 'get');
			form.setAttribute('action', '<%= contextPath + application.getInitParameter("WriteComment")%>');
			
			var hiddenField = document.createElement('input');
            hiddenField.setAttribute('type', 'hidden');
            hiddenField.setAttribute('name', 'mvIdx');
            hiddenField.setAttribute('value', <%=request.getAttribute("mvIdx")%>);
            form.appendChild(hiddenField);
            
		    document.body.appendChild(form);
		    form.submit();
		}
		
	}
</script>
</head>
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
		if(movies.getIdx().matches(request.getParameter("mvIdx"))){
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
		
		%><hr><h4>댓글목록</h4>
		<p id='WriteComment'style="display:inline-block;border-style: groove;border-width:1px;border-color:red;">Write Comment</p><%
		
		if(accList!=null){
			for(Entity comEnt: accList){//listing comments
				
				propHolder2=(String)application.getAttribute("Nullthumb");
				////show commenter's thumbnail
				if(comEnt.getImgs("thumb")!=null){
					propHolder=comEnt.getImgs("thumb").get(0);
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
				
				
				//edit link
				propHolder = comEnt.getProperty("COMMIDX");
				propHolder2 = request.getParameter("page");
				boolean hasPage = false;
				hasPage = propHolder2!=null && propHolder2!="";
				if(propHolder!=null){
				%>
				<a href='<%=contextPath+application.getInitParameter("WriteComment")%>?mvIdx=<%=request.getParameter("mvIdx")%>&commIdx=<%=propHolder%><%
				if(hasPage)out.print("&page="+propHolder2);
				%>'>Edit Comment</a>
				<%
				}else{
				}
				
				//delete link
				propHolder = comEnt.getProperty("COMMIDX");
				if(propHolder!=null){
				%>
				<a href='<%=contextPath+application.getInitParameter("WriteComment")%>?mvIdx=<%=request.getParameter("mvIdx")%>&isDelete=true&commIdx=<%=propHolder%><%
				if(hasPage)out.print("&page="+propHolder2);
				%>'style='color:red;'>Delete Comment</a>
				<%
				}else{
				}
				
				
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
			
			
			try{
				int pageAmount = (int)application.getAttribute("pageAmount");
				int pageNum =(int)request.getAttribute("pageNumber");
				int commCnt =(int)request.getAttribute("COMMCOUNT");
				int pageCommAmount = (int)request.getAttribute("PAGECOMMAMOUNT");
				int maxPage = (int)Math.ceil((double)commCnt/(double)pageCommAmount);
				int startPageNum;
				int endPageNum;
				
				if(pageNum<=pageAmount/2){
					startPageNum = 1;
					if(maxPage<=pageAmount){
						endPageNum = maxPage;
					}else{
						endPageNum=startPageNum+pageAmount-1;
					}
				}else if(pageNum<maxPage-pageAmount/2){
					startPageNum = pageAmount%2==0 ? pageNum - pageAmount/2+1 : pageNum - pageAmount/2;
					endPageNum = pageNum + pageAmount/2;
				} else {
					endPageNum = maxPage;
					startPageNum = maxPage-pageAmount+1;
				}
				
				for( ; startPageNum <= endPageNum ; startPageNum++ ){
					
					if(startPageNum==pageNum){
						%><p id='MoreComments'style="color:purple;"><%=startPageNum%></p><%
					}else{
						%><p id='MoreComments'><a href='<%=contextPath + application.getInitParameter("MoreComments")%>?mvIdx=<%=request.getParameter("mvIdx")%>&page=<%=startPageNum%>'><%=startPageNum%></a></p><%
					}
					
				}
			}catch(NullPointerException e){
				System.out.println("Null pointer while setting page number setting on more comment view!");
			}
			
			
		}else{
			System.err.println("No Comment found!");
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