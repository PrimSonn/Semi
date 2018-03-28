<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/FileUpload" method="post" enctype="multipart/form-data">
<label>첨부1 : <input type="file" name="file1" /></label><br>
<label>첨부2 : <input type="file" name="file2" /></label><br>
<label>첨부3 : <input type="file" name="file3" /></label><br>
<label>첨부4 : <input type="file" name="file4" /></label><br><br>
<button>파일 업로드</button>
</form>

<a href="/FileList">파일 리스트</a>

</body>
</html>