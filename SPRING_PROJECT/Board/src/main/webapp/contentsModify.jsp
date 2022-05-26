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
    String writer = request.getParameter("writer");
    String userId = request.getParameter("id");
    PostRepository postRepository = (PostRepository) application.getAttribute("postRepository");

    if (!writer.equals(userId)) {
        response.sendRedirect("wrongAccess.jsp");
    } else {
%>


<h1>modify</h1>

<div class="container">
    <form action="/contentModify.do">

        <label for="id">Writer Id</label>
        <input type="text" id="id" name="id" value="<%= postRepository.getPostByUserId(writer).getWriterUserId() %>">

        <label for="title">Title</label>
        <input type="text" id="title" name="title" placeholder="<%= postRepository.getPostByUserId(writer).getTitle() %>">

        <label for="localDateTime">Creation Time</label>
        <input type="text" id="localDateTime" name="localDateTime" placeholder="<%= postRepository.getPostByUserId(writer).getWriteTime() %>">

        <label for="text">Content</label>
        <textarea id="text" name="text" placeholder="<%= postRepository.getPostByUserId(writer).getContent() %>" style="height:200px"></textarea>

        <input type="submit" value="Modify">
    </form>
</div>
<%}%>

</body>
</html>
