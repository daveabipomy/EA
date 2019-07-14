<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Books currently in the shop</title>
</head>

<body>
	<h1>Books currently in the shop</h1>
	<table>
		<c:forEach var="Book" items="${Books}">
			<tr>
				<td>${Book.ttile}</td>
				<td>${Book.ISBN}</td>
				<td>${Book.author}</td>
				<td>${Book.price}</td>
				<td><a href="Books/${Book.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="Books/add"> Add a Book</a>
</body>

</html>