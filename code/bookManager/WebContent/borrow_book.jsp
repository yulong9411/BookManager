<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>借阅图书</title>
	<script type="text/javascript" src="js/jquery-1.8.3.js"/>
	<script type="text/javascript">
		$(document).ready(
			function(){
				$("#borrow").click(function(){
					var bookCode=$("#bookCode").val();
					var readerCode=$("#readerCode").val();
					$.ajax({
						type:"POST",
						url:"book_record/borrowBook",
						data:{
							"code":bookCode,
							"readerId":readerCode
						},
						success:function(data){
							alert(data.message);
							/*if(data.status!="200"){
								clear();
							}*/
						}
					});
				});
				
				$("#reset").click(function(){
					clear();
				});
			}
		);
		
		function clear(){
			$("#bookCode").val("");
			$("#readerCode").val("");
		}
	</script>
</head>
<body>
	<center>
		<h3>借阅图书</h3>
		<table>
			<tr>
				<th>图书编号</th>
				<th>读者编号</th>
			</tr>
			<tr>
				<td><input type="text" id="bookCode" placeholder="请输入图书编号"/></td>
				<td><input type="text" id="readerCode" placeholder="请输入读者编号"/></td>
			</tr>
			<tr>
				<td><input type="button" id="borrow" value="借阅"/></td>
				<td><input type="button" id="reset" value="重置"/></td>
			</tr>
		</table>
	</center>
</body>
</html>