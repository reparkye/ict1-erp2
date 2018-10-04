<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>

<c:if test="${iCnt}==1">
	alert("저장 성공");
	location.href="/levelinfo";
</c:if>
 
<form action="/levelinfo" method="POST">
	liname : <input type="text" name="liname"><br>
	lilevel :<input type="text" name="lilevel"><br>
	lidesc :<input type="text" name="lidesc"><br>
	<button>등록</button>
		
</form>
</body>
</html>