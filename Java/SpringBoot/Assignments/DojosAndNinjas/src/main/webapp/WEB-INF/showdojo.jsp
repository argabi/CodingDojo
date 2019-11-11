<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="margin:100px">

	<h1><c:out value="${dojo.name}"/></h1>
		<a href="/">Home</a> | <a href="/ninjas/new">Create Ninja</a>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td><c:out value="${ninja.first_name}"/></td>
					<td><c:out value="${ninja.last_name}"/></td>
					<td><c:out value="${ninja.age}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</div>

</body>
</html>