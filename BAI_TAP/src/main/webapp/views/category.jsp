<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category List</title>
<style>
table { width: 80%; margin: 20px auto; border-collapse: collapse; }
th, td { border: 1px solid #4CAF50; padding: 10px; text-align: center; }
th { background: #4CAF50; color: white; }
a { color: #4CAF50; text-decoration: none; margin: 0 5px; }
</style>
</head>
<body>
<h2 style="text-align:center; color:#4CAF50;">Danh mục sản phẩm</h2>
<table>
  <tr>
    <th>ID</th><th>Name</th><th>Icon</th><th>Action</th>
  </tr>
  <c:forEach items="${list}" var="c">
    <tr>
      <td>${c.id}</td>
      <td>${c.name}</td>
      <td>${c.icon}</td>
      <td>
        <a href="${pageContext.request.contextPath}/admin/category/edit?id=${c.id}">Edit</a> |
        <a href="${pageContext.request.contextPath}/admin/category/delete?id=${c.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
<p style="text-align:center;">
  <a href="${pageContext.request.contextPath}/admin/category/add">+ Add Category</a>
</p>
</body>
</html>
