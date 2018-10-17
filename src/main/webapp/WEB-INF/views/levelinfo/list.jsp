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
	var param = conf.param?conf.param:'{}';
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
				try{
					var res = JSON.parse(xhr.responseText);
					alert(res.errorMsg);
					return;
				}catch(e){
					
				}
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	if(method!='GET'){
		xhr.setRequestHeader('Content-type','application/json;charset=utf-8');
	} 
	this.send = function(){
		xhr.send(param);
	}
}
window.addEventListener('load',initList);
function initList(){
	document.querySelector('#liBody').innerHTML = '';
	var conf = {
			url : '/levelinfo',
			success : function(res){
				res = JSON.parse(res);
				var html = '';
				for(var li of res){
					html += '<tr>';
					html += '<td>' + li.linum + '</td>';
					html += '<td><input type="text" id="lilevel' + li.linum +'" value="' + li.lilevel + '"></td>';
					html += '<td><input type="text" id="liname' + li.linum +'" value="' + li.liname + '"></td>';
					html += '<td><input type="text" id="lidesc' + li.linum +'" value="' + li.lidesc + '"></td>';
					html += '<td><button onclick="updateLevelInfo(' + li.linum +')">수정</button>';
					html += '<button onclick="deleteLevelInfo(' + li.linum +')">삭제</button></td>';
					html += '</tr>';
				} 
				document.querySelector('#liBody').insertAdjacentHTML('beforeend',html);
				alert(2);
			}
	}
	var au = new AjaxUtil(conf);
	au.send();
	alert(1);
}
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
<button onclick="addLevelInfo()">레벨추가</button>
<script>
function addLevelInfo(){
	var html = '<tr>';
	html += '<td>&nbsp;</td>';
	html += '<td><input type="text" id="lilevel" value=""></td>';
	html += '<td><input type="text" id="liname" value=""></td>';
	html += '<td><input type="text" id="lidesc" value=""></td>';
	html += '<td><button onclick="saveLevelInfo()">저장</button></td>';
	html += '</tr>';
	document.querySelector('#liBody').insertAdjacentHTML('beforeend',html);
}
function saveLevelInfo(){
	var lilevel = document.querySelector("#lilevel").value;
	var liname = document.querySelector("#liname").value;
	var lidesc = document.querySelector("#lidesc").value;
	var params = {lilevel:lilevel, liname:liname, lidesc:lidesc};
	params = JSON.stringify(params);
	
	var conf = {
			url : '/levelinfo',
			method : 'POST',
			param : params,
			success : function(res){
				if(res=='1'){
					alert('저장 완료!!');
					initList();
				}
			}
	}
	var au = new AjaxUtil(conf);
	au.send();
}
function updateLevelInfo(linum){
	var lilevel = document.querySelector("#lilevel" + linum).value;
	var liname = document.querySelector("#liname" + linum).value;
	var lidesc = document.querySelector("#lidesc" + linum).value;
	var params = {lilevel:lilevel, liname:liname, lidesc:lidesc, linum:linum};
	params = JSON.stringify(params);
	
	var conf = {
			url : '/levelinfo2/' + linum,
			method : 'PUT',
			param : params,
			success : function(res){
				alert(res);
			}
	}
	
	var au = new AjaxUtil(conf);
	au.send();
}
function deleteLevelInfo(linum){
	var conf = {
			url : '/levelinfo/' + linum,
			method : 'DELETE',
			success : function(res){
				if(res=='1'){
					alert('삭제완료');
					initList();
				}
			}
	}
	var au = new AjaxUtil(conf);
	au.send();
};
</script>
</body>
</html>