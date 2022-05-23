<html lang="en">
<head>
    <title>HsYj DB Application PJ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');

        * {
            box-sizing: border-box;
            font-family: 'Jua', sans-serif;
        }

        body {
            margin: 0px;
            font-family: Arial, Helvetica, sans-serif;
        }

        /* Style the header */
        header {
            background-color: #F6DFEB;
            padding: 1%;
            text-align: center;
            font-size: 35px;
            color: rebeccapurple;
            margin-bottom: 20px;
        }

        /* Create two columns/boxes that floats next to each other */
        nav {
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            z-index: 1000;
            display: block;
            padding: 0 20px;
            overflow: hidden;
            background-color: #F6DFEB;
            width: 210px;
            height: auto;
            text-align: center;

        }

        /* Style the list inside the menu */
        nav ul {
            list-style-type: none;
            padding: 0px;
        }

        article {
            float: right;

            padding: 20px;
            width: 89%;
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
            padding: auto;
            text-align: center;
            color: white;
        }

        /* 로그인 폼 css */
        @media (max-width: 600px) {
            nav, article {
                width: 100%;
                height: auto;
            }
        }

        /* Bordered form */
        form {
            border: 3px solid #f1f1f1;
        }

        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        /* Add a hover effect for buttons */
        button:hover {
            opacity: 0.8;
        }

        /* Extra style for the cancel button (red) */
        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        /* Center the avatar image inside this container */
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        /* Avatar image */
        img.avatar {
            width: auto;
            border-radius: 50%;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
        }

        /* The "Forgot password" text */
        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }

            .cancelbtn {
                width: 100%;
            }
        }
    </style>
    </style>
</head>
<body>
<header>
    <h2>Board Main</h2>
</header>

<section>
    <nav>
        <ul>
            <h1>
                <div class="logo">
                    <a href="/"><img src="image/academy_top_logo-removebg-preview.png" alt="NHN Academy" title="NHN Academy"
                                     style="max-width: 100%; height: auto;"></a>
                </div>
            </h1>
            <li><a href="/login" style="color: white">Login</a></li>
            <li><a href="/boardList" style="color: white">BoardList</a></li>
            <li><a href="/boardWrite" style="color: white">Board</a></li>
        </ul>
    </nav>

    <article>

        <div class="logo">
            <a href="https://www.nhnacademy.com/"><img src="image/academy_top_logo-removebg-preview.png" alt="NHN Academy" title="NHN Academy"
                                                       style="max-width: 100%; height: auto;"></a>
        </div>
    </article>
</section>


</body>
</html>