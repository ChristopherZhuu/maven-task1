<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This is the result!
	<div>
		<h3 class="title">
			<span>图书管理</span>
		</h3>
		<table border="1" width="30%" class="tab">
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
			<c:forEach var="result" items="${selectByNameResult}">
				<tr>
					<td>${result.id}</td>
					<td>${result.bookName}</td>
					<td>${result.author}</td>
					<td>${result.price}</td>
					<td><a href="/maven_task1/Book/delete/${result.id}">delete</a>
						<a href="/maven_task1/Book/modify/${result.id}">modify</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
	<ul>
		<spring:url var="searchPageUrl"
			value="/Book/SearchResult"/>
		<c:forEach var="page" items="${pages}">
			<a href="${searchPageUrl}/${page.content}">${page.content}|</a>
			
		</c:forEach>

		<form:form action="${searchPageUrl}" method="post" modelAttribute="bookSearchForm">
    	Page:
    	<input type="text" value="${curPage}" name="pageIndex"/>
    	/<c:out value="${pageCnt}" />
    		<input type="submit" value="JUMP">
<%-- 			<a href="${searchPageUrl}"> <i></i>JUMP  --%>
			<!-- </a>  -->
			</form:form>
</ul>
	</div>
	<div>
		<a href="/maven_task1/Book/insert"><button>Insert</button></a>
	</div>
	<a href="../Book/Search">Return</a>
</body>
</html>