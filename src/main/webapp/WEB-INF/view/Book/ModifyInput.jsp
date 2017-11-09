<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Input</title>
</head>
<body>
<p>Input the details of the book:
<div>
		<form:form action="" method="post" modelAttribute="bookSearchForm">
			<p>编号：
			<input type="text" name="id" readonly="readonly" value="${bookSearchForm.id}" /> 
			<p>书名：
			<input type="text" name="bookName" value="${bookSearchForm.bookName}" />
			<p>作者：
			<input type="text" name="author" value="${bookSearchForm.author}" />
			<p>价格：
			<input type="text" name="price" value="${bookSearchForm.price}" />
			<button type="">Update</button>
		</form:form>
	</div>
	<div>
	<a href="../SearchResult">Return</a>
	</div>
	
</body>
</html>