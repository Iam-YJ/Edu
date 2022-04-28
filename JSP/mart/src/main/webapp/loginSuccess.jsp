<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    login success : <%= session.getAttribute("id")%>
    <br>
    <a href="/logout.do">Logout</a>
    <br>
</body>
</html>
