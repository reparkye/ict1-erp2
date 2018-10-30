<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<style>
	#lay{
	width:100%;
	height:100%;
	margin:auto 0px;
	}

</style>
<script>
	window.addEventListener('load',doInit);
	var dxLay;
	function doInit(){
		var conf = {
				pattern:'4H',//4개의 셀 h 형태 만약 6h로 한다면 가운데에 4개가 된다.
				parent:'lay',
				cells:[
					{id:"a",text:"Left",fix_size:[true,null]},	//a는 사이즈 안움직이게 함
					{id:"b",text:"middle top"},
					{id:"c",text:"middle bottom"},
					{id:"d",text:"Right"},
				]
		};
		
		dxLay = new dhtmlXLayoutObject(conf);
		dxLay.attachEvent('onDblClick',function(id){	//이벤트를 붙이다.dhtmlX만 적용
			alert(id);
		})
	}
</script>

</head>
<body>
<div id="lay"></div>
</body>
</html>