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

	<h1>Dojo Ninjas</h1>
	
		<a href="/dojos/new">Create Dojo</a> | <a href="/ninjas/new">Create Ninja</a>
		
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Dojo Name</th>
					<th>Ninja Count</th>
					<th>Date Created</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dojos}" var="dojo">
				<tr>
					<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
					<td><c:out value="${dojo.getNinjas().size()}"/> ninjas</td>
					<td><c:out value="${dojo.created_at}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

</div>

</body>
</html>