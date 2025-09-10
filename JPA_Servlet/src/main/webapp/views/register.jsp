<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
    <h2>Đăng ký</h2>
    <c:if test="${not empty alert}">
        <p style="color:red">${alert}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <label>Username:</label><input type="text" name="username"/><br/>
        <label>Fullname:</label><input type="text" name="fullname"/><br/>
        <label>Password:</label><input type="password" name="password"/><br/>
        <label>Phone:</label><input type="text" name="phone"/><br/>
        <label>Email:</label><input type="text" name="email"/><br/>
        <button type="submit">Register</button>
    </form>
    <p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
</body>
</html>
