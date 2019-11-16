<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<title>Task Manager - index page</title>
</head>
<body>
<br>

	<div class="container -fluid">
		   
		    <!-- logout Message   -->
		    
		<c:if test="${logoutMessage != null}">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
		
	 	 <strong> <c:out value="${logoutMessage}"></c:out> </strong>
	  
	  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	 	 </button>
		</div>

	    </c:if>
	    
	    
	    <!-- registration Message   -->
	    
	    <c:if test="${registrationMessage != null}">
	   		<div class="alert alert-success alert-dismissible fade show" role="alert">
		
	 	 <strong> <c:out value="${registrationMessage}"></c:out> </strong>
	  
	  	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	 	 </button>
		</div>
	    </c:if>
   
   </div>
        
<br>
<br>
<br>

	<div class="container">
      <div class="row">  
    
       	<div class="col">
       	
     <h1>Register</h1>
     
     <div class="text-danger">
      <p><form:errors path="user.*"/></p>
       </div>
       
     <div class="form-group row">
     
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label class=" col-form-label" path="name">Name:</form:label>
            <form:input class=" form-control" path="name"/>
        </p>
        
        <p>
            <form:label class="col-form-label" path="email">Email:</form:label>
            <form:input class="form-control"  path="email"/>
        </p>
        
        <p>
            <form:label class="col-form-label" path="password">Password:</form:label>
            <form:password class="form-control" path="password"/>
        </p>
        <p>
            <form:label class="col-form-label" path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
        </p>
        <input class="btn btn-primary" type="submit" value="Register"/>
    </form:form>
    
    </div>
    </div>
    
    
      <div class="col">
    <h1>Login</h1>
    
    <c:if test="${errorMessage != null}">
    	<div class="text-danger">
        <c:out value="${errorMessage}"></c:out>
        </div>
    </c:if>
    
    <div class="form-group row">
    
    <form method="POST" action="/"> <!-- /login -->
        <p>
            <label class="col-form-label" for="email">Email:</label>
            <input class="form-control" type="email" id="email" name="email"/>
        </p>
        <p>
            <label class="col-form-label" for="password">Password:</label>
            <input class="form-control" type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input class="btn btn-success" type="submit" value="Login"/>
    </form>
    
    </div>
    </div>
    </div>
    </div>
</body>
</html>