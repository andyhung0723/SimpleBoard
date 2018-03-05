<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>這4一個留言板</title>
<link rel="shortcut icon" href="images/Logo.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
	<div class="container">
		<center>
			<div id="loginPanel" style="padding-top:20px">
				<form method='post' action='login.do'>
					<table bgcolor='#cccccc' class="table table-bordered">
						<tr>
							<td colspan='2'>
								<img src='images/Title.png' style="display:block;margin:auto;" />
								<img src='images/HomePage.png' />
								<br/>
								<div align="center">
									<input type='text' name='username' placeholder="請填入名稱"
										class="form-control" value="${param.username}">
								</div> <br />
								<div align="center">
									<input type='password' name='password' placeholder="請填入密碼"
										class="form-control">
								</div> <br />
								<div align="center">
									<input type='submit' value='登入'
										class="btn btn-primary btn-sm btn-block">
								</div> <br />
								<div align="center">
									<a href='forgot.html'>忘記密碼？</a>
								</div>
							</td>
						</tr>
					</table>
					
					<div style="text-align: center;color: rgb(255, 0, 0);">
						 ${requestScope.error}
					</div>
					<br />
					<table bgcolor='#cccccc' class="table table-bordered">
						<tr>
							<td>
								<div align="center">沒有帳號嗎? <a href='register.jsp'>註冊</a></div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</center>
	</div>
</body>
</html>