<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h2>Welcome:${model_name}</h3>
<h3>Name:${model_name}</h3>
<h3>Email:${model_email}</h3>
<h3>phno:${model_phno}</h3> --%>



<%-- <h2>Welcome:${model_name}</h3>
<h3>Name:${model_user.getName()}</h3>
<h3>Email:${model_user.getEmail()}</h3>
<h3>phno:${model_user.getPhno()}</h3> --%>


<h2>Welcome:${user.getName()}</h3>
<h3>Name:${user.getName()}</h3>
<h3>Email:${user.getEmail()}</h3>
<h3>phno:${user.getPhno()}</h3>
</body>
</html>