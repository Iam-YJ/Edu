<%--
  Created by IntelliJ IDEA.
  User: park
  Date: 2022-04-28
  Time: 오전 6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>My Cart</h1>
양파: <%= session.getAttribute("onionCount")%>개 <br>

계란: <%= session.getAttribute("eggCount")%>개 <br>
파: <%= session.getAttribute("welshOnionCount")%>개 <br>
사과: <%= session.getAttribute("appleCount")%>개 <br>
합계: <%= session.getAttribute("result")%><br>
잔액 : <%= session.getAttribute("money") %> <br>

</body>
</html>
