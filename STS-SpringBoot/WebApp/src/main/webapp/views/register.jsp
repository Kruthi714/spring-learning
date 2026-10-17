<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="/CSS/style.css"
	</head>
	<body class="body_bg">
		<h4>Registration form</h4>
		<c:if test="${not empty successMsg}">
			<h4 style="color:green">${successMsg}</h4>
		</c:if>
		<c:if test="${not empty ErrorMsg}">
					<h4 style="color:red">${ErrorMsg}</h4>
				</c:if>
		<form action="regForm" method="post">
			Name : <input type="text" name="name" placeholder="Enter your name"/><br/><br/>
			Email : <input type="text" name="email" placeholder="Enter your email"/><br/><br/>
			Password : <input type="password" name="password" placeholder="Enter your password"/><br/><br/>
			PhoneNo : <input type="text" name="phoneno" placeholder="Enter your phno"/><br/><br/>
			<input type="submit" value="Register"/>
		</form>
		<br/><br/>
		If already registered....<a href="LoginPage"><b>click here</b></a>
		
	</body>
</html>