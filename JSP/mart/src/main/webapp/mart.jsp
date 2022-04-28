<%--
  Created by IntelliJ IDEA.
  User: park
  Date: 2022-04-28
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Welcome NHN Mart </h1>
<a href="/init"> Food Stand </a> <br>

<a href="/cart.jsp"> Cart</a> <br>

money : <%= session.getAttribute("money") %> <br>

<br>language <br>
<a href="ko"><%= application.getAttribute("ko") %></a> <br>
<a href="en"><%= application.getAttribute("en") %></a> <br>

</body>
</html>
