<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<%@ page import="dto.Video" %>
<%@ page import="dto.Image" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	List<Video> videos = (List)request.getAttribute("videos");
	for(Video v : videos) { %>
		<a href="/FileDownload?type=v&no=<%=v.getNo() %>"><%=v.getNo() %> <%=v.getVideo_name() %></a><br>
<%	}
	out.println("----------<br>");
	List<Image> images = (List)request.getAttribute("images");
	for(Image i : images) { %>
		<a href="/FileDownload?type=i&no=<%=i.getNo() %>"><%=i.getNo() %> <%=i.getImage() %></a><br>
<%	}
%>

</body>
</html>