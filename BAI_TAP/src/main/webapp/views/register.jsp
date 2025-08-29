<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
</head>
<body>
    <h2>Tạo tài khoản mới</h2>

    <c:if test="${alert != null}">
        <p style="color:red">${alert}</p>
    </c:if>

    <form action="register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Fullname:</label>
        <input type="text" name="fullname" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <label>Email:</label>
        <input type="email" name="email" required><br><br>

        <label>Phone:</label>
        <input type="text" name="phone"><br><br>

		<label>Role:</label>
	    <select name="roleid" required>
	        <option value="1">Admin</option>
	        <option value="2">Manager</option>
	        <option value="3" selected>User</option>
	    </select><br><br>
		
        <input type="submit" value="Đăng ký">
    </form>

    <p>Bạn đã có tài khoản? 
        <!-- <a href="login">Đăng nhập</a>  -->
        <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
    </p>
</body>
</html>
