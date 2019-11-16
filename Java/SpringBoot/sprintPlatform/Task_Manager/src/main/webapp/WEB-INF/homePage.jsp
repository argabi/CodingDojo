<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<title>Task Manager - Tasks</title>
</head>

<body>
<br>
<br>

<div class="container ">

<!--  header -->
<div class="container">
  <div class="row">
  
    <div class="col">
      <h1>Welcome, <c:out value="${currentUser.name}"></c:out></h1>
    </div>
    
    <div class="col-md-auto">
      <a href="/tasks/HightoLow">Priority High - Low</a> 
      </div>
      
      <div class="col-md-auto">
      <a href="/tasks/LowtoHigh">Priority Low - High</a>
    </div>
    
    <div class="col-sm">
     <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
        <input class="btn btn-link" type="submit" value="Logout!" />
    </form>
    </div>
    
  </div>
  </div>
  <!--   END header END -->
  <br>
  <!--  Table -->
  
  <table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Task</th>
					<th>Creator</th>
					<th>Assignee</th>
					<th>Priority</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${tasks}" var="thetask">
				<tr>
					<td> <a href="/tasks/${thetask.id}"><c:out value="${thetask.task_name}"/></a> </td>
					<td><c:out value="${thetask.creator.name}"/></td>
					<td><c:out value="${thetask.assignee}"/></td>
					
					<!--  if else  else -->
					<c:choose>
						  <c:when test="${thetask.priority == 1}">
						   <td>High</td>
						  </c:when>
						  <c:when test="${thetask.priority == 3}">
						    <td>Low</td>
						  </c:when>
						  
						  <c:otherwise>
						    <td>Medium</td>
						  </c:otherwise>
					</c:choose>
					
					<!-- <td><c:out value="${thetask.priority}"/></td>  -->
				</tr>
			</c:forEach>
			</tbody>
		</table>
  
  <!-- END Table END -->
  <br>
  <!-- Button create new Task -->
	
	<a class="btn btn-secondary" href="/tasks/new">Create Task</a>
	
  <!-- END  Button create new Task END -->

    
    
 </div>
</body>





</html>