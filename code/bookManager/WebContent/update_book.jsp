<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新图书</title>
</head>
<body>
	<center>
		<form url="book/updateBook" method="post">
			<table>
				<tr>
					<td>书名:</td>
					<td><input type="text" readonly="readonly" value="${ }"/></td>
				</tr>
				<tr>
					<td>ISBN码:</td>
					<td><input type="text" readonly="readonly" value="${ }"/></td>
				</tr>
				<tr>
					<td>图书编码:</td>
					<td><input type="text" readonly="readonly"  value="${ }"/></td>
				</tr>
				<tr>
					<td>作者:</td>
					<td><input type="text" readonly="readonly"  value="${ }"/></td>
				</tr>
				<tr>
					<td>类型:</td>
					<td>
						<select>
							<c:forEach var="category" items="${ }">
								<option>${category.type }</option>
							</c:forEach>	
						</select>
					</td>
				</tr>
				<tr>
					<td>出版社:</td>
					<td><input type="text" readonly="readonly" value="${ }"/></td>
				</tr>
				<tr>
					<td>出版时间:</td>
					<td><input type="text" readonly="readonly" value="${ }"/></td>
				</tr>
				<tr>
					<td>大图片:</td>
					<td><input type="file" name="imageLarge" value="${ }"/></td>
				</tr>
				<tr>
					<td>中等图片:</td>
					<td><input type="file" name="imageMedium" value="${ }"/></td>
				</tr>
				<tr>
					<td>小图片:</td>
					<td><input type="file" name="imageSmall" value="${ }"/></td>
				</tr>
				<tr>
					<td>概述:</td>
					<td><textarea rows="20" cols="10">${ }</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"/></td>
					<td><input type="reset" value="重置"/></td>
					<td><input type="button" value="取消"/></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>