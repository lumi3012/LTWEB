<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h2>Chào mừng, ${sessionScope.account.fullName}!</h2>
    <p>Bạn đã đăng nhập thành công với tài khoản: <b>${sessionScope.account.username}</b></p>

    <p>Vai trò của bạn là:
        <c:choose>
            <c:when test="${sessionScope.account.roleid == 1}">Admin</c:when>
            <c:when test="${sessionScope.account.roleid == 2}">Manager</c:when>
            <c:otherwise>User</c:otherwise>
        </c:choose>
    </p>

    <p><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></p>
</body>
</html>
