<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/UpdateUserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" value="${user.name}" name="name" readonly="readonly"
                   placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender=='男'}">
                <input type="radio" name="gender" value="男" checked/>男
                <input type="radio" name="gender" value="女"/>女
                <input type="radio" name="gender" value="未知"/>未知
            </c:if>

            <c:if test="${user.gender=='女'}">
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女" checked/>女
                <input type="radio" name="gender" value="未知"/>未知
            </c:if>
            <c:if test="${user.gender=='未知'}">
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
                <input type="radio" name="gender" value="未知" checked/>未知
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" value="${user.age}" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="address">住址：</label>
            <select name="address" id="address" value="${user.address}" class=" form-control">
                <c:if test="${user.address=='北辰东区'}">
                    <option value="北辰东区" selected>北辰东区</option>
                    <option value="北辰西区">北辰西区</option>
                    <option value="红桥南院">红桥南院</option>
                    <option value="红桥北院">红桥北院</option>
                    <option value="红桥东院">红桥东院</option>
                    <option value="大街上">大街上</option>
                </c:if>
                <c:if test="${user.address=='北辰西区'}">
                    <option value="北辰东区">北辰东区</option>
                    <option value="北辰西区" selected>北辰西区</option>
                    <option value="红桥南院">红桥南院</option>
                    <option value="红桥北院">红桥北院</option>
                    <option value="红桥东院">红桥东院</option>
                    <option value="大街上">大街上</option>
                </c:if><c:if test="${user.address=='红桥南院'}">
                <option value="北辰东区">北辰东区</option>
                <option value="北辰西区">北辰西区</option>
                <option value="红桥南院" selected>北辰红桥南院</option>
                <option value="红桥北院">红桥北院</option>
                <option value="红桥东院">红桥东院</option>
                <option value="大街上">大街上</option>
            </c:if><c:if test="${user.address=='红桥北院'}">
                <option value="北辰东区">北辰东区</option>
                <option value="北辰西区">北辰西区</option>
                <option value="红桥南院">红桥南院</option>
                <option value="红桥北院" selected>红桥北院</option>
                <option value="红桥东院">红桥东院</option>
                <option value="大街上">大街上</option>
            </c:if><c:if test="${user.address=='红桥东院'}">
                <option value="北辰东区">北辰东区</option>
                <option value="北辰西区">北辰西区</option>
                <option value="红桥南院">红桥南院</option>
                <option value="红桥北院">红桥北院</option>
                <option value="红桥东院" selected>红桥东院</option>
                <option value="大街上">大街上</option>
            </c:if><c:if test="${user.address=='大街上'}">
                <option value="北辰东区">北辰东区</option>
                <option value="北辰西区">北辰西区</option>
                <option value="红桥南院">红桥南院</option>
                <option value="红桥北院">红桥北院</option>
                <option value="红桥东院">红桥东院</option>
                <option value="大街上" selected>大街上</option>
            </c:if>

            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" value="${user.qq}" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" value="${user.email}" name="email"
                   placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>