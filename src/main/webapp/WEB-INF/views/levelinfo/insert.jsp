<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<script>
<c:if test="${!empty iCnt}">
	<c:if test="${iCnt eq 1}">
		alert("저장성공");
		location.href="/levelinfo";
	</c:if>
</c:if>
</script>
<form action="/levelinfo" method="post">
	liname : <input type="text" name="liname"><br>
	lilevel : <input type="text" name="lilevel"><br>
	lidesc : <input type="text" name="lidesc"><br>
	<button>레벨등록</button>
</form>
</body>
</html> 