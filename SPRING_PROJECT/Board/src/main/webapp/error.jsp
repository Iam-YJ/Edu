<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
Error:
<c:choose>
    <c:when test="${'RuntimeException'.equals(exception.getClass().name)}">${exception.getCause()}</c:when>
    <c:otherwise>${exception}</c:otherwise>
</c:choose>
<br />

<br />
<a href="/">Go to board</a>
</body>
</html>
