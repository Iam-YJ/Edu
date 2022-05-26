<%@ page import="com.nhnacademy.repo.PostRepository" %>
<%@ page import="com.nhnacademy.repo.UserRepository" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        form label {
            font-weight: bold
        }
    </style>
</head>
<body>

<%
    String userId = request.getParameter("id");
    String writer = request.getParameter("writer");
    UserRepository userRepository = (UserRepository) application.getAttribute("userRepository");
    User user = userRepository.getUser(userId);

%>


<h1>modify</h1>

<div class="container">
    <form action="/userModify.do" method="get">

        <label for="id">Id</label>
        <input type="text" id="id" name="id" value="<%= writer %>">

        <label for="pwd">Pwd</label>
        <input type="text" id="pwd" name="pwd" placeholder="password">

        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="name">

        <label for="image">Image</label>
        <textarea id="image" name="image" placeholder="image" style="height:200px"></textarea>

        <input type="submit" value="Modify">
    </form>
</div>

</body>
</html>
