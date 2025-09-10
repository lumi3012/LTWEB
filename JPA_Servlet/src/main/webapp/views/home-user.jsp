<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
</head>
<body>
    <h2>Xin chào, ${account.fullname} (User)</h2>
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
    <h3>Danh sách Category của bạn</h3>
    <c:forEach items="${categories}" var="c">
        <p>${c.id} - ${c.categoryName}</p>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/category/add">Thêm Category</a>
</body>
</html>
