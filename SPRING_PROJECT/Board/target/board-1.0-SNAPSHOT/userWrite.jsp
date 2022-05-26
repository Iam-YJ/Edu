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

<h1>Registered User</h1>

<div class="container">
    <form action="/userContent.do" method="post">

        <label for="id" >User Id</label>
        <input type="text" id="id" name="id" placeholder="Writer Id">

        <label for="pwd">User Pwd</label>
        <input type="text" id="pwd" name="pwd" placeholder="Title">

        <label for="name">User Name</label>
        <input type="text" id="name" name="name" placeholder="Creation Time">

        <label for="image">User Image</label>
        <textarea id="image" name="image" placeholder="Write something.." style="height:200px"></textarea>

        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
