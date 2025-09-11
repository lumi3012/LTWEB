<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.topbar {
	background: #2e7d32;
	color: #fff;
	padding: 12px 18px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	box-shadow: 0 2px 8px rgba(0, 0, 0, .15);
}

.topbar .brand a {
	color: #fff;
	text-decoration: none;
	font-weight: 700;
	letter-spacing: .5px;
}

.topbar nav a {
	color: #e8f5e9;
	margin: 0 10px;
	text-decoration: none;
}

.topbar nav a:hover {
	text-decoration: underline;
}

.topbar .right {
	display: flex;
	align-items: center;
	gap: 12px;
}

.topbar .btn {
	background: #43a047;
	color: #fff;
	padding: 6px 10px;
	border-radius: 6px;
	text-decoration: none;
	border: 1px solid rgba(255, 255, 255, .2);
}

.topbar .btn:hover {
	background: #1b5e20;
}

.spacer {
	height: 12px;
} /* nếu muốn chèn khoảng cách dưới thanh topbar */
</style>

<header class="topbar">
	<div class="brand">
		<a href="${pageContext.request.contextPath}/home">Luxury App</a>
	</div>
	<nav>
		<a href="${pageContext.request.contextPath}/home">Home</a>
		<!-- để trống thêm sau: <a href="#">Category</a> -->
	</nav>
	<div class="right">
		<c:choose>
			<c:when test="${not empty sessionScope.account}">
				<span>Xin chào, <b>${sessionScope.account.fullname}</b></span>
				<a class="btn" href="${pageContext.request.contextPath}/logout">Đăng
					xuất</a>
			</c:when>
			<c:otherwise>
				<a class="btn" href="${pageContext.request.contextPath}/login">Đăng
					nhập</a>
			</c:otherwise>
		</c:choose>
	</div>
</header>
<div class="spacer"></div>
