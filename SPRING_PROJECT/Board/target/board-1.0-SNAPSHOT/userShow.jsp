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

        input[type=text], select, input type

        =
        "text"
        {
            width: 100%
        ;
            padding: 12px
        ;
            border: 1px solid #ccc
        ;
            border-radius: 4px
        ;
            box-sizing: border-box
        ;
            margin-top: 6px
        ;
            margin-bottom: 16px
        ;
            resize: vertical
        ;
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

<h1></h1>

<div class="container">
    <% String writer = request.getParameter("writer");
        UserRepository userRepository = (UserRepository) application.getAttribute("userRepository");
        User user = userRepository.getUser(writer);
    %>

    <form>
        <label>Id</label><br>
        <text id="id" name="id"><%= user.getId() %>
        </text><br>

        <label>Pwd</label><br>
        <text id="pwd" name="pwd"><%= user.getPassword() %>
        </text><br>

        <label>Name</label><br>
        <text id="name" name="name"><%= user.getName() %>
        </text><br>

        <label>Image</label><br>
        <text id="image" name="image"><%= user.getProfileFileName() %>
        </text><br>

    </form>
</div>

</body>
</html>
