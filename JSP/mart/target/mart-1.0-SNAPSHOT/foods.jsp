<%@ page import="com.nhnacademy.mart.Food" %>
<%@ page import="com.nhnacademy.mart.FoodStand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% FoodStand foodStand = (FoodStand) application.getAttribute("foodStand"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/cart.do">
    <h1> Foods </h1>
    <% for(Food food : foodStand.getFoods()) {%>
        <div>상품명 :  <%= food.getName() %>
            가격 :  <%= food.getPrice() %>
            구매수량 입력 : <input type="text" name="<%= food.getName() %>" value="0"
            size="3">
        </div><br>
    <% } %>
    <input type="submit">
</form>

</body>
</html>
