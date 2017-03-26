<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>日志</title>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(
			loadLog(1)		
		);
	
		function loadLog(pageNo){
			$.ajax({
				type:"GET",
				url:"log_info/getAllLogInfo",
				dataType:"json",
				success:function(data){
					var backData=data.result;
					var pageNo=backData.pageNo;
					var pageSize=backData.pageSize;
					var list=backData.resultList;
					setData(list);
					for(var i=1;i<=pageSize;i++){
						$("#label").append("<label id='"+i+"' onclick='loadLog("+i+")'>"+i+"</label>");
						if(i==pageNo){
							$("#"+i).css("color","red");
						}
					}
				},
				error:function(){
					alert("出错了！！！！！！");
				}
			});			
		}
		
		function setData(list){
			for(var i=0;i<list.length;i++){
				var obj=list[i];
				$("#first").after("<tr><td>"+
						(i+1)+"</td>"+
						"<td>"+obj.user.managerId+"</td>"+
						"<td>"+obj.content+"</td>"+
						"<td>"+obj.operateTime+"</td>"
				+"</tr>");
			}
		}
	</script>
</head>
<body>
	<center>
		<table id="table">
			<tr id="first">
				<th>编号</th>
				<th>操作者</th>
				<th>操作内容</th>
				<th>操作时间</th>
			</tr>
		</table>
		<div id="label"></div>
	</center>
</body>
</html>