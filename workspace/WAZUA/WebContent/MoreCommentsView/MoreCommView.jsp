<%@page import="java.io.IOException"%>
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
	<br><hr><br><hr><br>
<%}
*/
//================================================================================


ArrayList<Entity> movList = pack.getList("MOVIE");
ArrayList<Entity> accList = pack.getList("ACCOUNT");
ArrayList<String> imgListHolder = null;
String propHolder=null, propHolder2=null;
Entity movie=null;

%><%! 
String propHolder=null, propHolder2=null;
JspWriter writer = null;
Entity movie=null;

public String capital(String s){
	return s=s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase();
}

public void write (String s)throws IOException {
		writer.print(s);
}

public void putProp (Entity ent,String tag) {	
	try{
		propHolder = ent.getProperty(tag);
		write("<div id=/'"+capital(tag)+"\''>");
		if(propHolder!=null){
			write("<p id=\'"+capital(tag)+" Ptag\'>");
				write(capital(tag)+": "+propHolder);
			write("</p>");
		}else{
			System.out.println(tag+"==null");
			write("<p id=\'"+capital(tag)+" Ptag\'></p>");
		}
		write("</div>");
	} catch(IOException o_0){
	}
}

public void putPropNoName (Entity ent,String tag) {	
	try{
		propHolder = ent.getProperty(tag);
		write("<div id=/'"+capital(tag)+"\''>");
		if(propHolder!=null){
			write("<p id=\'"+capital(tag)+" Ptag\'>");
				write(propHolder);
			write("</p>");
		}else{
			System.out.println(tag+"==null");
			write("<p id=\'"+capital(tag)+" Ptag\'></p>");
		}
		write("</div>");
		
	} catch(IOException o_0){
	}
}

%><%
writer = out;
String mvIdx = request.getParameter("mvIdx");

if(movList!=null){
	for(Entity movies: movList){
		if(movies.getIdx().matches(mvIdx)){
			movie = movies;
			break;
		}
	}
	if(movie!=null){
		
		//poster
		%><div id = MoviePoster><a href='<%=contextPath + application.getInitParameter("MoviePage")%>?mvIdx=<%=mvIdx%>'><%
		imgListHolder= movie.getImgs("poster");
		propHolder = (String)application.getAttribute("Nullposter");
		if(imgListHolder!=null){
			%><img src ='<%=imgListHolder.get(0)%>'><%
		}else if(propHolder!=null){
			%><img src ='<%=propHolder%>'><%
		}else{
			System.out.println("movie poster null!");//------------------------------------------test
			%><h4>Sorry, no poster found</h4><%
		}
		%></a></div><%
		
		
		//ENGTITLE + KORTITLE
		%><div id = MovieTitle><%
		propHolder = movie.getProperty("ENGTITLE");
		propHolder2 = movie.getProperty("KORTITLE");
		if(propHolder!=null){
			%><h4><%=propHolder%> (<%=propHolder2%>)</h4><%
		}else{
			if(propHolder2!=null){
				%><h4><%=propHolder2%></h4><%
			}else{
				%><h4>No MovieTItle found</h4><%
			}
		}
		%></div><%	
		
		%><hr><h4>댓글목록</h4>
		<p id='WriteComment'style="display:inline-block;border-style: groove;border-width:1px;border-color:red;">Write Comment</p><%
		
		if(accList!=null){
			for(Entity comEnt: accList){//listing comments
				
				propHolder2=(String)application.getAttribute("Nullthumb");
				
				//show commenter's thumbnail
				%><div id='Comment Thumb'><%
				if(comEnt.getImgs("thumb")!=null){
					propHolder=comEnt.getImgs("thumb").get(0);
					%><img src='<%=propHolder%>'/><%
				}else if(propHolder2!=null){//when there's no thumbnail on this guy.
					%><img src='<%=propHolder2%>'/><%
				}else{//no thumbnail, no contextAttribute thumbnail ready
				}
				%></div><%
				//show commenter's thumbnail ends
				
				//show commenter's name
				putPropNoName(comEnt,"NAME");
				
				//comment's SCORE
				putProp(comEnt,"SCORE");
				
				//comment's REGDATE
				putPropNoName(comEnt,"REGDATE");
				
				
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
				putPropNoName(comEnt,"CONTENTS");
				
			}//comment listing for ends
			
			
			//-----paging start
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
				
				//writing page link
				
				if(startPageNum>1){
				%><p id='MoreComments'><a href='<%=contextPath + application.getInitParameter("MoreComments")%>?mvIdx=<%=request.getParameter("mvIdx")%>&page=1'>&lt&lt</a></p><%
				}
					
				for( ; startPageNum<= endPageNum ; startPageNum++ ){//write page moving link for statement start
					
					if(startPageNum==pageNum){
						%><p id='MoreComments'style="color:purple;font-weight:bold;"><%=startPageNum%></p><%
					}else{
						%><p id='MoreComments'><a href='<%=contextPath + application.getInitParameter("MoreComments")%>?mvIdx=<%=request.getParameter("mvIdx")%>&page=<%=startPageNum%>'><%=startPageNum%></a></p><%
					}
					
				}//end of writing page for statement
				
				if(endPageNum<maxPage){
				%><p id='MoreComments'><a href='<%=contextPath + application.getInitParameter("MoreComments")%>?mvIdx=<%=request.getParameter("mvIdx")%>&page=<%=maxPage%>'>&gt&gt</a></p><%
				}
				
				//End of writing page link
				
				
			}catch(NullPointerException e){
				System.out.println("Null pointer while setting page number setting on more comment view!");
			}
			//---end of paging
			
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