<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
    <h2>Đăng nhập</h2>
    <c:if test="${not empty alert}">
        <p style="color:red">${alert}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Username:</label><input type="text" name="username"/><br/>
        <label>Password:</label><input type="password" name="password"/><br/>
        <button type="submit">Login</button>
    </form>
    <p>Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
</body>
</html>
