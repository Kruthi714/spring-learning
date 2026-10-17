<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="/CSS/style.css"
	</head>
	<body class="body_bg">
		<h4>Login form</h4>
		
		<c:if test="${not empty ErrorMsg}">
					<h4 style="color:red">${ErrorMsg}</h4>
				</c:if>
		<form action="LoginForm" method="post">
			Email : <input type="text" name="email1" placeholder="Enter your email"/><br/><br/>
			Password : <input type="password" name="password1" placeholder="Enter your password"/><br/><br/>
			<input type="submit" value="Login"/>
		</form>
		
	</body>
</html>