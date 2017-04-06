<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/manager_header.jsp" %>    
    
<script type="text/javascript">
		$(document).ready(
			function(){
				$("#add").click(function(){
					var isbn=$("#isbnCode").val();
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
				
				$("#reset").click(function(){
					clear();
				});
			}		
		);
		
		function clear(){
			$("#isbnCode").val("");
		}
	</script>
<!-- content start -->

<ol class="breadcrumb">
    <li><a href="/bookManager/module/manager_header.jsp">Home</a></li>
    <li><a href="/bookManager/module/manager_header.jsp">图书管理</a></li>
    <li class="active">添加图书</li>
</ol>

<center>
		<table>
			<tr>
				<td>ISBN码:</td>
				<td><input type="text" id="isbnCode" placeholder="请输入图书的ISBN码"/></td>
			</tr>
			<tr>
				<td><input type="button" id="add" value="添加"/></td>
				<td><input type="button" id="reset" value="重置"/></td>
			</tr>
		</table>
	</center>
	
<!-- content end -->
<%@ include file="/module/footer.jsp"%>