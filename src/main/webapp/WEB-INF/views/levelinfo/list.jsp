<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="levelinfo" method="get">
	liname : <input type="text" name="liname">
	<button>검색</button>
</form>
<table border="1">
	<thead>
		<tr>
			<th>linum</th>
			<th>lilevel</th>
			<th>liname</th>
			<th>lidesc</th>
		</tr>	
	</thead>
	<tbody>
		<c:if test="${empty liList}">
			<tr>
				<td colspan="4">레벨 목록이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items="${liList}" var="li">
			<tr>
				<td>${li.linum}</td>
				<td><input type="text" name="lilevel${li.linum}" value="${li.lilevel }"></td>
				<td><input type="text" name="liname${li.linum}" value="${li.liname }"></td>
				<td><input type="text" name="lidesc${li.linum}" value="${li.lidesc }"></td>
				<td><button type="button" onclick="updateLevelInfo(${li.linum })">수정</button>
				<td><button type="button" onclick="deleteLevelInfo(${li.linum })">삭제</button>
			</tr>
			</c:forEach>
	</tbody>
</table>
<script>
	function updateLevelInfo(linum){
		var lilevel = document.querySelector("input[name=lilevel" + linum + "]").value;
		var liname = document.querySelector("input[name=liname" + linum + "]").value;
		var lidesc = document.querySelector("input[name=lidesc" + linum + "]").value;
		alert(lilevel + "," + liname + "," + lidesc);
	}
	
	function deleteLevelInfo(linum){
		alert(linum);
		var xhr = new XMLHTTpRequest();
		var url = "/levelinfo/" + linum;
		var method = "delete";
		xhr.open(method,url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=="200"){
					alert("ok");
				}eles{
					alert("실패");
				}
			}
		}
		xhr.send();
	}


</script>
</body>
</html>