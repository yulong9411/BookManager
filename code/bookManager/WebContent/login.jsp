<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign in</title>
</head>
<body>
	<form action="goLogining",method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" placeholder="请输入工号或读者编号"/></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" placeholder="请输入密码"/></td>
			</tr>
			<tr>
				<td><input type="radio" name="type" value="0">读者</td>
				<td><input type="radio" name="type" value="1">管理员</td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
		</table>
	</form>
</body>
</html>