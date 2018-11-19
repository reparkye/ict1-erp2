<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<input type="text" id="source"><button onclick="transper()">번역</button>
<textarea id="target"></textarea>
<script>
 	var url = 'https://openapi.naver.com/v1/papago/n2mt';
	var id ='cB8NkIYOd2vf2ZzQz4BA';
	var sec = 'R_oB447JUq';
	function transper(){
		var source = document.querySelector('#source').value;
		var param = 'source=en&target=ko&text=' + source;
		var xhr = new XMLHttpRequest();
		xhr.open('POST',url);
		xhr.setRequestHeader('X-Naver-Client-Id',id);
		xhr.setRequestHeader('X-Naver-Client-Secret',sec);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded; charset=UTF-8');
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					console.log(xhr.responseText);
				}
			}
		}
		xhr.send(param);
	}
</script>
</body>
</html> 