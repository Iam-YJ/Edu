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

        input[type=button] {
            background-color: darkred;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        input[type=button]:hover {
            background-color: darkred;
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


<h1>Delete ? </h1>

<div class="container">
    <form action="/contentsDeleteSuccess.do">
        <input type="submit" value="Yes">
        <input type="button" value="No" onclick="location.href='/'">

        <input type="hidden" id="id" name="id" value="<%= postRepository.getPostByUserId(writer).getWriterUserId() %>">

    </form>
</div>
<%}%>

</body>
</html>
