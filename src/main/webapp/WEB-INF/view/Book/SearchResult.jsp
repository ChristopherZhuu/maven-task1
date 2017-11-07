<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is the result!
<div>
        <h3 class="title"><span>图书管理</span></h3>       
        <table border="1" width="30%" class="tab">
            <tr>               
                <th>编号</th>
                <th>书名</th>   
                <th>作者</th>
                <th>价格</th>                          
            </tr>
            <c:forEach var="result" items="${selectByNameResult}">
                <tr>                  
                    <td>${result.id}</td>
                    <td>${result.bookName}</td>
                    <td>${result.author}</td> 
                    <td>${result.price}</td>                                    
                </tr>
            </c:forEach>
        </table>    
    </div>
</body>
</html>