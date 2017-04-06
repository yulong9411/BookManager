<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/head_import.jsp"%>
<body>
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">管理</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown">
					图书管理
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">添加图书</a></li>
					<li><a href="#">删除图书</a></li>
					<li><a href="#">修改图书</a></li>
					<li><a href="#">查看图书</a></li>
				</ul>
			</li>
			<li>
				<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown">
					读者管理
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">添加读者</a></li>
					<li><a href="#">删除读者</a></li>
					<li><a href="#">修改读者</a></li>
					<li><a href="#">查看读者</a></li>
				</ul>
			</li>
			</li>
		</ul>
	</div>
	</div>
</nav>
