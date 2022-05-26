<%@ page import="com.nhnacademy.domain.Posts" %>
<%@ page import="com.nhnacademy.domain.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="board" var="board"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>BOARD</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        /* Style the header */
        header {
            background-color: #666;
            padding: 30px;
            text-align: center;
            font-size: 35px;
            color: white;
        }

        /* Create two columns/boxes that floats next to each other */
        nav {
            float: left;
            width: 30%;
            height: 300px; /* only for demonstration, should be removed */
            background: #ccc;
            padding: 20px;
        }

        /* Style the list inside the menu */
        nav ul {
            list-style-type: none;
            padding: 0;
        }

        article {
            float: left;
            padding: 20px;
            width: 70%;
            background-color: #f1f1f1;
            height: 300px; /* only for demonstration, should be removed */
        }

        /* Clear floats after the columns */
        section::after {
            content: "";
            display: table;
            clear: both;
        }

        /* Style the footer */
        footer {
            background-color: #777;
            padding: 10px;
            text-align: center;
            color: white;
        }

        /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
        @media (max-width: 600px) {
            nav, article {
                width: 100%;
                height: auto;
            }
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        .button {
            border: none;
            color: white;
            padding: 10px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 10px;
            margin: 4px 2px;
            cursor: pointer;
        }

        a {
            text-decoration: none;
            display: inline-block;
            padding: 5px 5px;
        }

        a:hover {
            background-color: white;
            color: black;
        }

        .previous {
            background-color: #f1f1f1;
            color: black;
            float: right;
        }

        .next {
            background-color: #666;
            color: white;
            float: right;
        }

        .button1 {
            background-color: #4CAF50;
        }

        /* Green */
        .button2 {
            background-color: #008CBA;
        }

        /* Blue */
        .button3 {
            background-color: #D0312D;
        }

        /* Red */
    </style>
</head>
<body>
<header>
    <h2><fmt:message key="NHNACADEMY" bundle="${board}"/></h2>
</header>

<section>
    <nav>
        <ul>
            <li><a href="/registerForm.jsp"><fmt:message key="REGISTER" bundle="${board}"/></a></li>
            <li><a href="/login.do"><fmt:message key="LOGIN" bundle="${board}"/></a></li>
            <li><a href="/wrongAccess.jsp"><fmt:message key="WRITE" bundle="${board}"/></a></li>
        </ul>
    </nav>

    <article>
        <a href="/change-lang.do?lang=ko" class="previous"><fmt:message key="Ko" bundle="${board}"/></a>
        <a href="/change-lang.do?lang=en" class="next"><fmt:message key="En" bundle="${board}"/></a>
        <table>
            <tr>
                <th><fmt:message key="Article" bundle="${board}"/></th>
                <th><fmt:message key="Writer" bundle="${board}"/></th>
                <th><fmt:message key="Etc" bundle="${board}"/></th>
            </tr>

            <tr>
                <td><fmt:message key="PLI" bundle="${board}"/></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </article>
    <%--    <td><javatime:format value="${post.writeTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>--%>
</section>

<footer>
    <p><fmt:message key="YJ" bundle="${board}"/></p><br/>
</footer>

</body>
</html>

