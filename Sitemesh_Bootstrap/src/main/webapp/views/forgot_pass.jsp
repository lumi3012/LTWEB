<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<style>
.forgot-box {
  width: 320px; margin: 50px auto; padding: 20px;
  border: 2px solid #4CAF50; border-radius: 10px;
  background: #f6fff6; text-align: center;
}
button { background: #4CAF50; color: white; padding: 10px; border: none; border-radius: 5px; }
.alert { color: red; margin: 10px 0; }
</style>
</head>
<body>
<div class="forgot-box">
  <h2>Quên mật khẩu</h2>
  <c:if test="${not empty alert}">
      <p class="alert">${alert}</p>
  </c:if>
  <form action="${pageContext.request.contextPath}/forgot" method="post">
      <input type="email" name="email" placeholder="Nhập email" required><br><br>
      <button type="submit">Lấy lại mật khẩu</button>
  </form>
  <p><a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a></p>
</div>
</body>
</html>
