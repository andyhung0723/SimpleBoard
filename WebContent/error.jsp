<%@ page import="java.util.List" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="images/Logo.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>新增會員失敗</title>
</head>
<body>
	<center>
		<div class="container">

			<img src="images/Error.jpg" alt="Card image">

			<strong><h2>新增會員失敗</h2></strong>
			<p>
				<%
					List<String> errors = (List<String>) request.getAttribute("errors");
					for (String error : errors) {
				%>
				<%=error%><br />
				<%
					}
				%>
			</p>
			<a class="btn btn-primary" href='register.jsp'>返回註冊頁面</a>
		
		</div>
	</center>
</body>
</html>