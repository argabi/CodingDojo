<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
     
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>New Person</title>
</head>
<body>

<h1>New Person</h1>

<form:form action="/acreatePerson" method="post" modelAttribute="personForm">
		
		<p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    	</p>
    	
    	<p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    	</p>
    	
	
    <input type="submit" value="Submit"/>
    
   
</form:form>    

</body>
</html>