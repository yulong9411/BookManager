<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login_control</title>
<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(
		function(){
			var page="${bean.result}";
			var message="${bean.message}";
			var status="${bean.status}";
			alert(message);
			if(page==""){
				location.href="login.jsp";
			}else{
				location.href=page;
			}
		}		
	);
</script>
</head>
<body>
</body>
</html>