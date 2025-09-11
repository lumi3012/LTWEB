<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
<header>
    <nav>
        <a href="${pageContext.request.contextPath}/home">Home</a>
        <c:if test="${not empty sessionScope.account}">
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </c:if>
        <c:if test="${empty sessionScope.account}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
            <a href="${pageContext.request.contextPath}/register">Register</a>
        </c:if>
        <c:if test="${sessionScope.account.roleId == 1}">
            <a href="${pageContext.request.contextPath}/admin/category">Manage Categories</a>
        </c:if>
    </nav>
</header>
<main>
