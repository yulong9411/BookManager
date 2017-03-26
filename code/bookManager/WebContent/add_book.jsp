<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>图书录入</title>
	<script type="text/javascript" src="js/jquery-1.8.3.js"/>
	<script type="text/javascript">
		$(document).ready(
			function(){
				var isbn=$("#isbnCode").val();
				$("#add").click(function(){
					$.ajax({
						type:"POST",
						url:"book/addBookByCode",
						data:{
							"isbnCode":isbn
						},
						dataType:"json",
						success:function(data){
							alert(data.message+"  isbn="+isbn);
							if(!data.status=='200'){
								clear();
							}
						}
					});
				});
				
				("#reset").click(function(){
					clear();
				});
			}		
		);
		
		function clear(){
			$("#isbnCode").val("");
		}
	</script>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>ISBN码:</td>
				<td><input type="text" id="isbnCode" placeholder="请输入图书的ISBN码"/></td>
			</tr>
			<tr>
				<td><input type="button" id="add" value="添加"/></td>
				<td><input type="button" id="reset" values="重置"/></td>
			</tr>
		</table>
	</center>
</body>
</html>