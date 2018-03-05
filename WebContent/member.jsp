<%@ page import="java.util.*, java.text.*, zn.model.Blah"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet Blog練習</title>
<link rel="shortcut icon" href="images/Logo.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="css/bootstrap-dialog.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="js/bootstrap-dialog.min.js"></script>
<script
	src="js/member.js"></script>
<link rel="stylesheet" href="css/member.css" type="text/css">
</head>

<body>
	<div class="container">
		<div class='leftPanel'>
			<h1 align="center">${sessionScope.login}的留言板</h1>
			<br /> <img src='images/Member.png' width='80%' height='80%' /><br>
			<br> 
			<div align="center">
				<a href='logout.do?username=${sessionScope.login}'>登出
					${sessionScope.login} </a>
			</div>
		</div>
		
		<table style='text-align: left; width: 510px; height: 88px; margin-top: 20px;'
			border='1' cellpadding='2' cellspacing='2'>
			<tbody>
				<c:forEach var="blah" items="${requestScope.blahs}">
					<tr>
						<td style="vertical-align: top;" bgcolor='#FFFFBB'>
							<div style="float:left;padding-left: 5px;">
								<span class="glyphicon glyphicon-user"></span> ${blah.username}
							</div>
							<div style="float:right;padding-right: 5px;">
								<a href='delete.do?message=${blah.date.time}'>刪除</a>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							${blah.txt}
						</td>
					</tr>
					<tr>
						<td>
							<div style="float:right;padding-right: 10px;">
								<fmt:formatDate value="${blah.date}" type="both" dateStyle="default" timeStyle="default"/>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr style='width: 100%; height: 1px;'>
		
		<div align="center">
			<form method='post' action='message.do'>
				留言...<br>
				<c:if test="${requestScope.blabla != null}">
					訊息要140字以內<br>
				</c:if>
				<input type="hidden" name="formhash" id="formhash" value="${requestScope.formhash}" />
				<textarea cols='60' rows='4' name='blabla' style="text-align: left;">${requestScope.blabla}</textarea>
				<br>
				<button type='submit' class="btn btn-primary btn-sm">送出</button>
			</form>
		</div>
	</div>

<!-- 卡控測試  -->
<c:if test="${requestScope.error != null}">
	<script language="javascript">
		DialogTest();
	</script>
</c:if>

	 
</body>
</html>