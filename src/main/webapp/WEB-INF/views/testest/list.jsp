<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "/css/bt-337/dist/css/bootstrap.css/">
<link rel = "stylesheet" href = "/css/bt-337/dist/css/bootstrap.theme.css/">

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
			iff(xhr.status=="200"){
				success(xhr.responseText);
			}else{
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	if(method!='GET'){
		xhr.RequestHeader('Content-type','application/json;charset=utf-8');
	}
	this.send = function(){
		xhr.send(param);
	}	
}		
window.addEventListener('load',function(){
	var conf = {
			url : '/Libraryinfo',
			success:function(res){
				res = JSON.parse(res);
				var html = '';
				for(var li of res){
					html += '<tr>';
					html += '<td>' + li.lino + '</td>';
					html += '<td><input type="text" id="liname' + li.lino+'" value="' + li.liname + '"></td>';
					html += '<td><input type="text" id="liprice' + li.lino+'" value="' + li.liprice + '"></td>';
					html += '<td><input type="text" id="ligenre' + li.lino+'" value="' + li.ligenre + '"></td>';
					html += '<td><input type="text" id="lidate' + li.lino+'" value="' + li.lidate + '"></td>';
					html += '<td><input type="text" id="lipublisher' + li.lino+'" value="' + li.lipublisher + '"></td>';
					html += '<td><input type="text" id="liwriter' + li.lino+'" value="' + li.liwriter + '"></td>';
					html += '<td><input type="text" id="liwhere' + li.lino+'" value="' + li.liwhere + '"></td>';
					html += '<td><input type="text" id="liimg' + li.lino+'" value="' + li.liimg + '"></td>';
					html += '<td><input type="text" id="libook' + li.lino+'" value="' + li.libook + '"></td>';
					
					/* html +='<td><select name="listar" + li.lino id="listar"'
					html +='<option value ="1">1</option>';
					html +='<option value ="2">2</option>';
					html +='<option value ="3">3</option>'; 
					html +='<option value ="4">4</option>'; 
					html +='<option value ="5" selected>5</option>'; 
					html +='</select>'; */
						
					html += '<td><input type="text" id="listar' + li.lino+'" value="' + li.listar + '"></td>';
					html += '</tr>';
				}
				document.querySelector(#liBody).insertAdjacentHTML('beforeend',html);
	}
	}
	var au = new AjaxUtil(conf);
	au.send();
});		
</script>		
		
<body>

liname : <input type="text" name="liname">
<button>검색</button>
<table border='1'>
	<thead>
		<tr>
			<th>lino</th>
			<th>liname</th>
			<th>liprice</th>
			<th>ligenre</th>
			<th>lidate</th>
			<th>lipublisher</th>
			<th>liwriter</th>
			<th>liwhere</th>
			<th>liimg</th>
			<th>libook</th>
			<th>listar</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody id="liBody">
	</tbody>
</table>
<button onclick="addLibraryInfo()">도서 추가</button>
<script>
function addLibraryInfo(){
		var html = '<tr>';
		html += '<td>&nbsp;</td>';
		html += '<td><input type="text" id="liname" value=""></td>';
		html += '<td><input type="text" id="liprice" value=""></td>';
		html += '<td><input type="text" id="ligenre" value=""></td>';
		html += '<td><input type="text" id="lidate" value=""></td>';
		html += '<td><input type="text" id="lipublisher" value=""></td>';
		html += '<td><input type="text" id="liwriter" value=""></td>';
		html += '<td><input type="text" id="liwhere" value=""></td>';
		html += '<td><input type="text" id="liimg" value=""></td>';
		html += '<td><input type="text" id="libook" value=""></td>';
		html += '<td><input type="text" id="listar" value=""></td>';
		html += '</tr>';
		doucment.querySelector('#liBody').insertAdjacentHTML('beforeend,html');
}

function saveLibraryInfo(){
	var liname = document.querySelector('#liname').value;	
	var liprice = document.querySelector('#liprice').value;	
	var ligenre = document.querySelector('#ligenre').value;	
	var lidate = document.querySelector('#lidate').value;	
	var lipublisher = document.querySelector('#lipublisher').value;	
	var liwriter = document.querySelector('#liwriter').value;	
	var liwhere = document.querySelector('#liwhere').value;	
	var liimg = document.querySelector('#liimg').value;	
	var libook = document.querySelector('#libook').value;	
	var listar = document.querySelector('#listar').value;	
	var params = {liname:liname, liprice:liprice, ligenre:ligenre, lidate:lidate, lipublisher:lipublisher, 
			liwriter:liwriter, liwhere:liwhere, liimg:liimg, libook:libook, listar:listar};
	params = JSON.parse(params);
	
	var conf = {
			url :'/libraryInfo/';
			method : 'POST';
			param : params;
	
			success : function(res){
				if(res=='1'){
					alert('저장');
					initList();
				}
			}
	}
		var au = new AjaxUtil(conf);
	au.send();
}	

function updateLibraryInfo(lino){
	var liname = document.querySelector("#liname"+lino).value;
	var liprice = document.querySelector("#liprice"+lino).value;
	var ligenre = document.querySelector("#ligenre"+lino).value;
	var lidate = document.querySelector("#lidate"+lino).value;
	var lipublisher = document.querySelector("#lipublisher"+lino).value;
	var liwriter = document.querySelector("#liwriter"+lino).value;
	var liwhere = document.querySelector("#liwhere"+lino).value;
	var liimg = document.querySelector("#liimg"+lino).value;
	var libook = document.querySelector("#libook"+lino).value;
	var listar = document.querySelector("#listar"+lino).value;
	params = {liname:liname, liprice:liprice, ligenre:ligenre, lidate:lidate, lipublisher:lipublisher, 
			liwriter:liwriter, liwhere:liwhere, liimg:liimg, libook:libook, listar:listar lino:lino};
	params = JSON.parse(params);
	
	var conf = {
			url : '/libraryinfo/' + linum,
			method : 'PUT';
			param : params;
	success : function(res){
		alert(res);
	}
	}
	var au = new AjaxUtil(conf);
	au.send();
}
function deleteLibraryInfo(lino){
	var conf = {
			url : '/libraryinfo' + lino,
			method : 'DELETE',
			success : function(res){
				if(res==1){
					alert('삭제');
					location.href="/url/libraryinfo:list";
				}
			}
	}
	var au = new AjaxUtil(conf);
	au.send;
}


}
}

</script>
</body>
</html>