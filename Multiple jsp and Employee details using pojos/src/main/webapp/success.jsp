<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Login success</h1>
<%

String usr=(String)session.getAttribute("info");
String dt=(String)session.getAttribute("userinfo");
out.println("Session Object:"+usr);
out.println("Content Object Data:"+dt);


%>
</body>
</html>