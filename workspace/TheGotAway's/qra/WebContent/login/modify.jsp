<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	Connection conn;
	Statement stmt;
	ResultSet res;
	
	String name,id,pw,phone1,phone2,phone3,gender;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	id= (String)session.getAttribute("id");

	String query = "select * from member where id = '" + id + "'";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	stmt = conn.createStatement();
	res = stmt.executeQuery(query);
	
	while(res.next()){
		name = res.getString("name");
		pw = res.getString("pw");
		phone1 = res.getString("phone1");
		phone2 = res.getString("phone2");
		phone3 = res.getString("phone3");
		gender = res.getString("gender");
	}
		
%>

<form action="ModifyOk" method="post">
	이름 : <input type = "text" name = "name" size="10" value="<%=name%>"><br>
	아이디: <%=id %><br>
	비밀번호 : <input type = "text" name = "pw" size="10"><br>
	전화번호 : <select name="phone1">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="012">012</option>
		<option value="013">013</option>
		<option value="014">014</option>
	</select> -
	<input type = "text" name="phone2" size="5" value=<%=phone2%>> - <input type = "text" name="phone3" size="5"value=<%=phone3%>>
	<%if(gender.equals("man")){ %>
	성별 구분 : <input type="radio" name = "gender" value="man" checked="checked">남 &nbsp;<input type="radio" name = "gender" value="woman">여<br>
	<%
	} else{
	%>
	성별 구분 : <input type="radio" name = "gender" value="man">남 &nbsp;<input type="radio" name = "gender" value="woman" checked="checked">여<br>
	<%
	}
	%>
	<button>저장</button><button type="reset">취소</button>
</form>
</body>
</html>