<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--  This will allow us to render this view on a PUT request.-->
    <%@ page isErrorPage="true" %>    
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<h1 class="text-success">Edit Book</h1>


<!--  -->
<div class="container">
<form:form action="/books/${book.id}/ali" method="POST" modelAttribute="book">
	
	<!-- method=RequestMethod.PUT -->
    <input type="hidden" name="_method" value="put">
    
    <p>
   		<form:errors class="text-success" path="title"/>
     
        <form:label path="title" >Title</form:label>
       
        <form:input class="form-group text-success"  path="title"/>
    </p>
    
    <p >
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description" class="form-group form-control"/>
    </p>
    
    <p>
        <form:label path="language">Language</form:label>//
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages"/>     
        <form:input type="number" path="numberOfPages"/>
    </p> 
       
    <input type="submit" value="Submit"/>
    
</form:form>
</div>

</body>
</html>