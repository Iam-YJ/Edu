<%@ page import="com.nhnacademy.domain.Posts" %>
<%@ page import="com.nhnacademy.domain.Post" %>
<%@ page import="com.nhnacademy.repo.PostRepository" %>
<%@ page import="com.nhnacademy.repo.UserRepository" %>
<%@ page import="com.nhnacademy.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="board" var="board"/>

<%
    if(session.getAttribute("id").equals("admin")){
        response.sendRedirect("adminBoard.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>ADMIN BOARD</title>
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
    <h2><fmt:message key="NHNACADEMYAD" bundle="${board}"/></h2>
</header>

<section>
    <nav>
        <ul>
            <li><a href="/userWrite.jsp"><fmt:message key="REGISTERAD" bundle="${board}"/></a></li>
            <li><a href="/logout.do"><fmt:message key="LOGOUT" bundle="${board}"/></a></li>
        </ul>
    </nav>

    <article>
        <a href="/change-lang.do?lang=ko" class="previous"><fmt:message key="Ko" bundle="${board}"/></a>
        <a href="/change-lang.do?lang=en" class="next"><fmt:message key="En" bundle="${board}"/></a>
        <table>
            <tr>
                <th><fmt:message key="USERNAME" bundle="${board}"/></th>
                <th><fmt:message key="Etc" bundle="${board}"/></th>
            </tr>

            <% UserRepository userRepository = (UserRepository) application.getAttribute("userRepository");
                for(User user : userRepository.getUsers()){%>
            <tr>
                <td><%= user.getName() %>
                </td>
                <td>
                    <button class="button button1"
                            onclick="location.href='userShow.jsp?writer=<%= user.getId() %>'" name="id"
                    ><fmt:message key="SHOW"
                                  bundle="${board}"/></button>
                    <button class="button button2"
                            onclick="location.href='userModify.jsp?id=<%=session.getAttribute("id")%>&writer=<%= user.getId() %>'" name="id"
                    ><fmt:message
                            key="MODIFY"
                            bundle="${board}"/></button>
                    <button class="button button3" onclick="location.href='userDelete.jsp?id=<%=session.getAttribute("id")%>&writer=<%= user.getId() %>'"
                            name="id"
                    ><fmt:message key="DELETE"
                                  bundle="${board}"/></button>
                </td>
            </tr>
            <% } %>

        </table>
    </article>

</section>

<footer>
    <p><fmt:message key="YJ" bundle="${board}"/></p><br/>
</footer>

</body>
</html>

