<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div align="center">
    <div>${user.name},欢迎您</div>
    <a
            href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=1&rows=5"
            style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
</div>
</body>
</html>