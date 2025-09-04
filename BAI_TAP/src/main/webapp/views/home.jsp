<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<style>
  body { font-family: Arial, sans-serif; background:#f0f4f0; margin:0; }
  .container {
    max-width: 960px; margin: 24px auto; padding: 0 16px;
  }
  .hero {
    background:#e8f5e9; border:1px solid #c8e6c9; border-radius:12px;
    padding: 24px; text-align:center;
    box-shadow: 0 6px 15px rgba(0,0,0,.08);
  }
  .hero h1 { color:#2e7d32; margin:0 0 8px 0; }
  .hero p { color:#2f3b2f; margin: 6px 0; }
  .pill {
    display:inline-block; background:#43a047; color:#fff; padding:6px 10px;
    border-radius:20px; font-size:13px; margin-top:8px;
  }
</style>
</head>
<body>

  <jsp:include page="/views/topbar.jsp" />

  <div class="container">
    <div class="hero">
      <h1>Chào mừng, ${sessionScope.account.fullname}!</h1>
      <p>Đăng nhập thành công với tài khoản <b>${sessionScope.account.username}</b>.</p>
      <p>Email: ${sessionScope.account.email} • SĐT: ${sessionScope.account.phone}</p>
      <p class="pill">
        Vai trò:
        <c:choose>
          <c:when test="${sessionScope.account.roleid == 1}">Admin</c:when>
          <c:when test="${sessionScope.account.roleid == 2}">Manager</c:when>
          <c:otherwise>User</c:otherwise>
        </c:choose>
      </p>
      <p><a href="${pageContext.request.contextPath}/admin/category/list">Quản lý Category</a></p>
    </div>

    <!-- Khu vực Category sẽ thêm sau ở đây -->
  </div>
</body>
</html>
