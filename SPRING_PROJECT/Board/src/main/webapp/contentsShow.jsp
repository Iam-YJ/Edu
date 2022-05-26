<%@ page import="com.nhnacademy.repo.PostRepository" %>
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
    <% String writer = request.getParameter("writer"); %>
    <% PostRepository postRepository = (PostRepository) application.getAttribute("postRepository"); %>

    <form>
        <label>Writer Id</label><br>
        <text id="id" name="id"><%= postRepository.getPostByUserId(writer).getWriterUserId() %>
        </text><br>

        <label>Writer Id</label><br>
        <text id="id" name="id"><%= postRepository.getPostByUserId(writer).getTitle() %>
        </text><br>

        <label>Writer Id</label><br>
        <text id="id" name="id"><%= postRepository.getPostByUserId(writer).getWriteTime() %>
        </text><br>

        <label>Writer Id</label><br>
        <text id="id" name="id"><%= postRepository.getPostByUserId(writer).getContent() %>
        </text><br>

    </form>
</div>

</body>
</html>
