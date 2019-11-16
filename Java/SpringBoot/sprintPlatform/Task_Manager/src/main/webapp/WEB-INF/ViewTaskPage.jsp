<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<title>Task Manager"> </title>

 
    
</head>

<body>
<div class="container ">
<br>
<br>

<h1>Task: <c:out value="${theTaskInfo.task_name}"> </c:out> </h1>
 <br>
 
 <div class="row justify-content-start"> 
  
 	<!-- Creator -->
 	<div class="col-sm">
		 <h4>Creator: </h4>
	 </div>
	 <div class="col-sm">
		 <h4><c:out value="${theTaskInfo.creator.name}"></c:out></h4>
 	</div>
  
  
 <div class="w-100"></div>
 
 
 <!-- Assignee -->
 	<div class="col-sm">
		 <h4>Assignee: </h4>
	 </div>
	 <div class="col-sm">
		 <h4><c:out value="${theTaskInfo.assignee}"></c:out></h4>
 	</div>
 
 
 <div class="w-100"></div>
 	
 <!-- priority -->
 	<div class="col-sm">
		 <h4>Priority: </h4>
	 </div>
	 <div class="col-sm">
		 <c:choose>
		  <c:when test="${theTaskInfo.priority == 1}">
		   <h4>High</h4>
		  </c:when>
		  <c:when test="${theTaskInfo.priority == 3}">
		  <h4>Low</h4>
		   </c:when>
		    <c:otherwise>
		  <h4>Medium</h4>
		  </c:otherwise>
	</c:choose>
 	</div>
 
 <div class="w-100"></div>
 <div class="w-100"></div>
 <!-- ------------------------------------------------------------------------- -->
  <br>
  
 <!-- Edit button -->
 		<c:if test="${currentUserID == theTaskInfo.creator.id}">
	 	 <a class="btn btn-secondary" href="/tasks/${theTaskInfo.id}/edit">Edit</a>
	    </c:if>
 
	 
	 <div class="w-100"></div>
	 
 <br>
 
	 <!-- Delete/completed Button -->
	 
 	<form id="deleteForm" method="POST" action="/tasks/${theTaskInfo.id}/delete">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
        <c:if test="${currentUserID == theTaskInfo.creator.id}">
        <input class="btn btn-secondary" type="submit" value="Delete" />
        </c:if>
         
          <c:if test="${currentUserName == theTaskInfo.assignee}">
        <input class="btn btn-primary" type="submit" value="Completed" />
        </c:if>
        
    </form>
 
 
  <div class="w-100"></div>
  
  
 
 </div>
 </div>
</body>

</html>



















