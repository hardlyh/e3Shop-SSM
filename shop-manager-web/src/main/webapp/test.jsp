<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<head>
<script type="text/javascript">

$(function(){
	
	$.post("test/test1",function(data){
		alert(data);
	})
	
	
})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

</body>
</html>