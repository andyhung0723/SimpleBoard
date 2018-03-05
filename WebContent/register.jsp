<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>這4註冊</title>
<link rel="shortcut icon" href="images/Logo.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
	
	<div class="container" align = "center">
		<div id="loginPanel" style="padding-top:20px">
			<form method='post' action='register.do'>
				<table class="table table-bordered">
					<tr>
						<td colspan='2'><br />
							<img src='images/Title.png' style="display:block;margin:auto;" />
							<img src='images/HomePage.png' />
							<br/>
							<div align="center">
								<input type='text' name='email' placeholder="請填入電子郵件"
									class="form-control" value="${param.email}">
							</div> <br />
							<div align="center">
								<input type='text' name='username' placeholder="請填入名稱"
									class="form-control" value="${param.username}">
							</div> <br />
							<div align="center">
								<input type='password' name='password' placeholder="請填入密碼"
									class="form-control">
							</div> <br />
							<div align="center">
								<input type='password' name='confirmPasswd'
									placeholder="請填入確認密碼" class="form-control">
							</div> <br />
							<div align="center">
								<input type='submit' value='註冊'
									class="btn btn-primary btn-sm btn-block">
							</div> <br />
						</td>
					</tr>
				</table>
				
				
				
				<c:if test="${requestScope.errors != null}">
					<div style="text-align: center;color: rgb(255, 0, 0);">
						<c:forEach var="error" items="${requestScope.errors}">
							${error}<br/>
						</c:forEach>
					</div>
				</c:if>
				
				<br/>
				<table class="table table-bordered">
					<tr>
						<td>
							<div align="center">
								已有帳號嗎? <a href='index.jsp'>登入</a>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>