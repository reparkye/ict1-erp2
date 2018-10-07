 <%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<script>
var AjaxUtil = function(conf){
	var xhr = new XMLHttpRequest();
	var url = conf.url;
	var method = conf.method?conf.method:'GET';
	var param = conf.param;
	
	var success = conf.success?conf.success:function(res){
		alert(res);
	}
	var error = conf.error?conf.error:function(res){
		alert(res);
	}
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				success(xhr.responseText);
			}else{
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	this.send = function(){
		xhr.send();
	}
}
 window.addEventListener('load',function(){
	var conf = {
			url : '/levelinfo',
			success : function(res){
				res = JSON.parse(res);
				var html = '';
				for(var li of res){
					html += '<tr>';
					html += '<td>' + li.linum + '</td>';
					html += '<td>' + li.lilevel + '</td>';
					html += '<td>' + li.liname + '</td>';
					html += '<td>' + li.lidesc + '</td>';
					html += '<td><button>수정</button><button>삭제</button></td>';
					html += '</tr>';
				} 
				document.querySelector('#liBody').insertAdjacentHTML('beforeend',html);
			}
	}
	var au = new AjaxUtil(conf);
	au.send();
});
</script>
<body> 

liname : <input type="text" name="liname">
<button>검색</button>
<table border="1">
	<thead>
		<tr>
 			<th>linum</th>
 			<th>lilevel</th>
 			<th>liname</th>
 			<th>lidesc</th>
			<th>수정/삭제</th>
		</tr>
	</thead>
	
	<tbody id="liBody">
	</tbody>
</table>
<script>
 function updateLevelInfo(linum){
 	var lilelve = document.querySelector("input[name=lilevel" + linum + "]").value;
 	var liname = document.querySelector("input[name=liname" + linum + "]").value;
 	var lidesc = document.querySelector("input[name=lidesc" + linum + "]").value;
	alert(lilelve + "," + liname + "," +lidesc);
}
function deleteLevelInfo(linum){
	
}
</script>
</body>
 </html>