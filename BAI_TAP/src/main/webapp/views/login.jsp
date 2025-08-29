<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
    <h2>Đăng nhập</h2>

    <c:if test="${alert != null}">
        <p style="color:red">${alert}</p>
    </c:if>

    <form action="login" method="post">
        <label>username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <label>Ghi nhớ đăng nhập</label>
        <input type="checkbox" name="remember"><br><br>

        <input type="submit" value="Đăng nhập">
    </form>

    <p>Bạn chưa có tài khoản? 
        <!--<a href="register">Đăng ký</a>-->
        <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
    </p>
</body>
</html>
