<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="path" value="<%=path%>"/>
<html>
<head>
    <title>欢迎</title>
    <script>
        var path='${path}'
    </script>
</head>
<body>
    <jsp:include page="frame/head.jsp"/>
    <h1>&nbsp;&nbsp;&nbsp;&nbsp;欢迎你,${username}</h1>
    <jsp:include page="frame/foot.jsp"/>
</body>
</html>
