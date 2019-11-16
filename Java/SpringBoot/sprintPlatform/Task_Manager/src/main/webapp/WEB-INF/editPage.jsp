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


<title>Task Manager - New Task</title>

 
    
</head>

<body>
<br>
<br>

<div class="container ">

  <!-- error Messages   -->
	    
	  <div class="text-danger">
      <p><form:errors path="user.*"/></p>
       </div>


<h1>Edit: <c:out value="${theTaskInfo.task_name}"> </c:out> </h1>
 <br>
 
  <div class="form-group row">
    
    <form:form action="/tasks/${theTaskInfo.id}/edit" method="POST" modelAttribute="task"> 
       
        <p>
            <label class="col-form-label" for="task_name">Task:</label>
            <input class="form-control" type="text" id="task_name" name="task_name" value="${theTaskInfo.task_name}"/>
        </p>
        
        <!-- list  assignees-->
        <p>
         <label class="col-form-label" for="assignee">Assignee:</label>
			<select  class="form-control" id="assignee" name="assignee">
				<c:forEach items="${assignees}" var="theassignee">
						
						<!-- selecte  -->
						 <c:if test="${theassignee.name == theTaskInfo.assignee}">
        				<option selected="selected" value="${theassignee.name}"><c:out value="${theassignee.name}"/></option>
        				</c:if>
        				
        				<option value="${theassignee.name}"><c:out value="${theassignee.name}"/></option>
   				</c:forEach>
			</select>
		</p>
        <!-- list assignees -->
        
        
        <!-- L M H -->
        <p>
         <label class="col-form-label" for="priority">Priority:</label>
			<select  class="form-control"  id="priority" name="priority">
			
			 <c:choose>
		    	<c:when test="${theTaskInfo.priority == 1}">
		       <option selected="selected" value="1">High</option>
		       <option value="2">Medium</option>
		   	   <option value="3">Low</option>
		    	</c:when>   
		    	
		    	 <c:when test="${theTaskInfo.priority == 3}">
		       <option  value="1">High</option>
		       <option value="2">Medium</option>
		   	   <option selected="selected" value="3">Low</option>
		    	</c:when>  
		    	
		    	<c:otherwise>
		       <option  value="1">High</option>
		       <option selected="selected" value="2">Medium</option>
		   	   <option value="3">Low</option>
		    	</c:otherwise>
			</c:choose>
	
			</select>
		</p>
         <!-- L M H -->
         
     


        <!-- Button submit -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input class="btn btn-secondary" type="submit" value="Edit"/>
    </form:form>
    
    </div>
 
 
 
 
 
 
 
 <!-- ----------------- -->
 </div>
</body>

</html>