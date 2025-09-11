<!-- <%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %> -->
<!DOCTYPE html>
<html>
<head>
    <title><decorator:title default="My Web App"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <decorator:body/>

    <%@ include file="footer.jsp" %>
</body>
</html>
