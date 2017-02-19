<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>注册</title>
    <script>
        var contextPath='${pageContext.request.contextPath}';
    </script>
</head>
<body ng-app="visitorModule" ng-controller="visitorCtrl" ng-init="test()">
    <form method="post">
        <p>用户名:<input type="text" name="username" /></p>
        <p>密码:<input type="password" name="password" /></p>
        <p><input type="submit" value="注册" /></p>
    </form>

    <script src="${pageContext.request.contextPath}/statics/js/angular/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/app/visitor/js/visitorCtrl.js"></script>
</body>
</html>
