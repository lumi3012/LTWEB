<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
</head>
<body>
    <h2>Danh sách Category</h2>
    <c:forEach items="${categories}" var="c">
        <p>${c.id} - ${c.categoryName} (UserID: ${c.user.id})</p>
    </c:forEach>
</body>
</html>
