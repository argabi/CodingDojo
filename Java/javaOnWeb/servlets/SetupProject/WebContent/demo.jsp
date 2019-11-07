	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"
	    import="java.util.Date"
	    %>
	    
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="windows-1256">
	<title>title ali</title>
	</head>
	<body>
	<h1>hi ali jsp</h1>
	
	<!-- this is a declaration tag for methods -->
	
	<%!
	public int add ( int a , int b)
	{
		return a+b;
	}
	
	%>
	<!-- this is a tag for any java code -->
	<% int i = 1;
	int j = 2;
	%>
	 <!-- shortcut to output whatever returns from our method call %> -->
	<h3><%= add(i,j) %></h3>
	
	<%  for(int index =0; index <5 ; index ++)  { %>
	
	<h1><%= index %></h1>
	
	<% } %>
	<!-- here we have to import the Date class. You will put the import in the first line of the jsp tag. Use the import attribute -->
	<p> the time is: <%= new Date() %> </p>
	</body>
	</html>