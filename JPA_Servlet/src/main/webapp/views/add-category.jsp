<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Category</title>
</head>
<body>
    <h2>Thêm Category</h2>
    <form action="${pageContext.request.contextPath}/category/add" method="post">
        <label>Tên Category:</label><input type="text" name="categoryName"/><br/>
        <label>Icon:</label><input type="text" name="icon"/><br/>
        <button type="submit">Thêm</button>
    </form>
</body>
</html>
