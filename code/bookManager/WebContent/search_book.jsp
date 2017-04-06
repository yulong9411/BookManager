<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/manager_header.jsp" %> 
<style>
	.shenglue{
		width: 300px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}	
</style>

<!-- content start -->
<ol class="breadcrumb">
    <li><a href="${ctx }/module/manager_header.jsp">Home</a></li>
    <li><a href="${ctx }/module/manager_header.jsp">图书管理</a></li>
    <li class="active">查看图书</li>
</ol>

<center>
	<table class="table">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>出版时间</th>
			<th>图书编号</th>
			<th>ISBN码</th>
			<th>编辑时间</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach var="book" items="${bean.result.resultList }" varStatus="varStatus">
			<td>${varStatus.count }</td>
			<td>${book.title }</td>
			<td>${book.author }</td>
			<td>${book.publisher }</td>
			<td>${book.pubDate }</td>
			<td>${book.code }</td>
			<td>${book.isbnCode }</td>
			<td>${book.editTime }</td>
			<td><p class="shenglue">${book.summary }</p></td>
			<td>
				<div class="btn-group">
					<input value="修改" type="button" class=".btn"/>
					<input value="删除" type="button" class=".btn"/>
				</div>
			</td>
		</c:forEach>
	</table>
	
	<ul class="pagination">
	    <li><a href="#">&laquo;</a></li>
	   	<c:forEach begin="1" end="${bean.result.pageCount }" var="i">
	   		<li><a href="#" <c:if test="${(i+1)==bean.result.pageNo }">class='active'</c:if> >${i }</a></li>
	   	</c:forEach>
	    <li><a href="#">&raquo;</a></li>
	</ul>
	
</center>
<!-- content end -->
<%@ include file="/module/footer.jsp"%>