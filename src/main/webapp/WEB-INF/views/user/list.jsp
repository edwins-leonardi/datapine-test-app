<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datapine - List Users</title>
</head>
<body>
	
	<spring:url value="/users/add" var="url"/>
	<a href="${url}">Add New</a>
	<br/>
	
	<table style="border: 1px">
		<tr><th>Id</th><th>Email</th><th>Actions</th></tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.email}</td>
				<td><a href='<c:url value="/users/${user.id}"/>'>View</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>