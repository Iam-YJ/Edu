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

        form label {font-weight:bold}
    </style>
</head>
<body>

<h1>Let's write something</h1>

<div class="container">
    <form action="/writeContent.do" method="post">

        <label for="id" >Writer Id</label>
        <input type="text" id="id" name="id" placeholder="Writer Id">

        <label for="title">Title</label>
        <input type="text" id="title" name="title" placeholder="Title">

        <label for="localDateTime">Creation Time</label>
        <input type="text" id="localDateTime" name="localDateTime" placeholder="Creation Time">

        <label for="text">Content</label>
        <textarea id="text" name="text" placeholder="Write something.." style="height:200px"></textarea>

        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
