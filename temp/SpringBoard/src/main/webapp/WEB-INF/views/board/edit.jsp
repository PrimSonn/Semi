<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/board/resources/smarteditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
<h3>edit Page</h3>
<hr>
<%
String nick = (String)session.getAttribute("nick");
%>
<form action="edit" method="post">
	<div class="form-group">
		<label for="writer">작성자</label>
		<input type="text" id="writer" name="writer" 
			value="${board.writerId}" readonly="readonly"
			class="form-control"/>
	</div>
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" id="title" name="title" 
			class="form-control" value="${board.title }" />
	</div>
	<div class="form-group">
		<label for="content">본문</label>
		<textarea rows="10" id="content" name="content">${board.content }</textarea>
	</div>
	<div>
		<input type='hidden' name="boardNo" value="${board.boardNo }"/>
	</div>
	<button id="btnWrite">작성</button>
</form>
<script>

var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "content",
    sSkinURI: "/board/resources/smarteditor/SmartEditor2Skin.html",
    fCreator: "createSEditor2",
    htParams : {
    	bUseToolbar: true, // 툴바 사용여부
    	bUseVerticalResizer: false, //입력창 크기 조절바
    	bUseModeChanger: true //모드 탭
    }
});

function submitContents(elClickedObj) {
    // 에디터의 내용이 textarea에 적용된다.
    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

    // 에디터의 내용에 대한 값 검증은 이곳에서
    // document.getElementById("ir1").value를 이용해서 처리한다.
    try {
        elClickedObj.form.submit();
    } catch(e) {}
}

$(document).ready(function(){
	$("#btnWrite").click(function(){
		submitContents($(this));
	})
})

</script>
</body>
</html>