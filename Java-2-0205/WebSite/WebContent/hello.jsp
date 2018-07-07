<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Server time:
		<%
			Date now = new Date(); 
			out.print(String.format("%tR", now));
		%>
	</h1>
	<% 
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		if (userName == null) userName = "";
		String hello = userName.isEmpty() ? "Привет":
			String.format("Привет, %s!", userName);
		
		// if (request.getMethod().equals("POST")) ...
	%>
	<h1>
		<%=hello %>
	</h1>
	<form method="POST">
		<label>Имя: </label>
		<input type=text name=userName>
		<input type=submit value=Hello>
	</form>

</body>
</html>