<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DatadaFool</title>
</head>
<body>
	<!--  SCRIPTLET TAGS -->
	
	<%
		String user = request.getParameter("user");
		String pas = request.getParameter("pwd");
		session.setAttribute("info",user);
		
		if(user.equals("admin") && pas.equals("java"))
		{
			%>
			<jsp:forward page="success.jsp"></jsp:forward>
			<%			
		}else
		{
			out.println("Invalid Credentials ");
			%>
			<jsp:include page="login2.jsp"></jsp:include>
			<%
		}
	%>
</body>
</html>