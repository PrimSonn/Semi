<%@page import="java.io.IOException"%>
<%@page import="java.util.Stack"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Hashtable" %>
<%@page import="moviePage.dto.entities.Entity"%>
<%@page import="moviePage.dto.Pack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WazuaMovie</title>
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
ArrayList<Entity> movGuyList = pack.getList("MOVIEGUYS");
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

public void putProp (String tag) {	
	try{
		propHolder = movie.getProperty(tag);
		if(propHolder!=null){
			write("<div id=\'"+capital(tag)+"\'>");
				write("<p id=\'"+capital(tag)+" Ptag\'>");
					write(capital(tag)+": "+propHolder);
				write("</p>");
			write("</div>");
		}else{
			System.out.println(tag+"==null");
			write("<div id=\'"+capital(tag)+"\'>");
			write("<p id=\'"+capital(tag)+" Ptag\'></p>");
			write("</div>");
		}
	} catch(IOException o_0){
	}
}
%><%
writer = out;

if(movList!=null){
	for(Entity movies: movList){
		if(movies.getIdx().matches((String)request.getAttribute("mvIdx"))){
			movie = movies;
			break;
		}
	}
	if(movie!=null){
		
		ArrayList<String> imgListHolder = null;
		
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
		
		//AVGSCORE + SCORECOUNT
		propHolder = movie.getProperty("AVGSCORE");
		propHolder2 = movie.getProperty("SCORECOUNT");
		if(propHolder!=null&propHolder2!=null){
			%>
			<div id='MvScore VoteCount'>
			<p id='MvScore Ptag'>MvScore: <%=propHolder%></p>
			<p id='VoteCount Ptag'>(<%=propHolder2%> votes)</p>
			</div>
			<%
		}else{
			System.out.println("(AVGSCORE|SCORECOUNT)==null");//------------------------------------------test
			%>
			<div id='MvScore VoteCount'>
			<p id='MvScore Ptag'></p>
			<p id='VoteCount Ptag'></p>
			</div>
			<%
		}
		
		//COUNTRY
		putProp("COUNTRY");
		//GENRE
		putProp("GENRE");
		//RATING
		putProp("RATING");
		//PLAYTIME
		putProp("PLAYTIME");
		//WISHCOUNT.......
		//----------------
		
		%>
		<hr>
		<%
		//play screen
		//stealcuts
		imgListHolder= movie.getImgs("stealcuts");
		if(imgListHolder!=null){
			for(String stealcuts: imgListHolder){
				%><div id = MovieStealcuts><img src ='<%=stealcuts%>'/></div><br><%
			}
		}else{
			%><div id = MovieStealcuts></div><br><%
		}
		
		%><hr><h4>COMMENT</h4><%
		//COMMENTCOUNT
		putProp("COMMENTCOUNT");
		
		//Comments
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
		}else{
			//when there's no comments
		}
		%>
		<hr>
		<h3>Information</h3>
		<h5>summary</h5>
		<%
		//COMMENTCOUNT
		putProp("COMMENTCOUNT");
		
		
		//--------actors and such guys ...
		Hashtable<String,Stack<Entity>> guyshash = new Hashtable<String,Stack<Entity>>();
		try{
			String role = null;
			for(Entity guys : movGuyList){
				role = guys.getProperty("ROLE");
				if(guyshash.containsKey(role)){
					guyshash.get(role).push(guys);
				}else{
					Stack<Entity> temp = new Stack<Entity>();
					temp.push(guys);
					guyshash.put(role,temp);
				}
			}
		}catch (NullPointerException e){
			System.out.println("Null while Hashing");//----------------test
		}

		try{
			for(String role: guyshash.keySet()){ %>
				<h4><%=role %></h4><hr>
				<% Stack<Entity> stack = guyshash.get(role);
				while(!stack.empty()){
					Entity guy = stack.pop();
					if(guy.getImgs("thumb") !=null){
						%>
						<div id = 'movGuyThumb'>
						<img src = '<%=guy.getImgs("thumb").get(0)%>'/>
						<%
					}else{
						%>
						<div id = 'movGuyThumb'>
						<%
					}
					if(guy.getProperty("NAME")!=null){
						%>
						<p><%=guy.getProperty("NAME")%>
						<%
					}
					if(guy.getProperty("CHARACTER")!=null){
						%>
						(<%=guy.getProperty("CHARACTER")%> 역)</p></div>
						<%
					}else{
						%></p></div><%
					}
				}//stack while ends
			}//guyhash for ends
		}catch(NullPointerException e){
			System.out.println("Exception on guyhash for statement");//------------------------------test
		}
		
		
	}else{
		System.err.println("no match movie");
		%>
		<div>
		<h2>Oops!sorry, can't find that movie.</h2>
		</div>
		<%
	}
}else{
	%>
	<div>
	<h2>Oops!sorry, No movie found.</h2>
	</div>
	<%
}


%>


</body>
</html>