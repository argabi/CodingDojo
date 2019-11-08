<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>


<br>
<div class="container">
<br>

<br>
 <small class="form-text text-danger">< c:out value="${errorCode}" /></small>

<br>

<form method="POST" action="/code" >
  <div class="form-group">
  
   <label >What is the code?</label>
   <input type="text" class="form-control" name="textCode">

  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

</body>
</html>