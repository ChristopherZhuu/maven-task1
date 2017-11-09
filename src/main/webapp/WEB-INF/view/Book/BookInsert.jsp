<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert a Book</title>
</head>
<body>
<p>Please input the details of the book you want to insert:
<div>
		<form:form action="/maven_task1/Book/InsertConfirm" method="post" modelAttribute="bookSearchForm">
			<p>编号：
			<input type="text" name="id" /> 
			<p>书名：
			<input type="text" name="bookName"/>
			<p>作者：
			<input type="text" name="author"/>
			<p>价格：
			<input type="text" name="price"/>
			<button type="submit" >Insert</button>
		</form:form>
	</div>
	<div>
	<a href="../SearchResult">Return</a>
	</div>
	
</body>
</html>