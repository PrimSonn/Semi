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
<%Pack pack = (Pack)request.getAttribute("pack");

ArrayList<Entity> movList = pack.getList("MOVIE");
ArrayList<Entity> accList = pack.getList("ACCOUNT");
ArrayList<Entity> movGuyList = pack.getList("MOVIEGUYS");

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
<%}%>

<div id = MoviePoster><img src ='<%=pack.getMvImg("poster").get(0)%>'/></div>
<hr>
<%
for(String stealcuts : pack.getMvImg("stealcuts")){%>
	<div id = MovieStealcuts><img src ='<%=stealcuts%>'/></div><br>
<%
}%>
<hr>

<%
for(Entity ent: movGuyList){
	%>
	<div id = 'movGuyThumb'><img src = '<%=ent.getImgs("thumb").get(0)%>'/></div>
	<%
}
%>



</body>
</html>