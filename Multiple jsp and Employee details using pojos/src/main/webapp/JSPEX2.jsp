<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP TAGS EXAMPLE</h1>
<!-- Declaration Tag -->
<%!
int x=30;
int y=50;
public int add(){
	return x+y;
}

String str="java";
%> 

<!-- Expression Tag -->
<%= add() %>

<!-- scriptlet tag -->
<%
out.println("Current Date:"+new Date());
%>
<br>
<%
out.println("Hi Hello Welcome all");

%>

 
</body>
</html>