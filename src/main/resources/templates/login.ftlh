<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            background-color: rgba(250, 240, 230, 1);
            margin: auto;
        }

        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 35px;
        }

        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
        }
        .button {
            height:24px;
            width: 36px;
            font-size:13px;
        }

        a {
            text-decoration: none;
            color: #8686c8;
            font-size: 17px;

        }
        a:hover {
            color: #d64d94;
        }
    </style>

</head>
<body align ="center">

<header style="margin: 0; padding: 0; ">
    <div id="menu">
        <ul fr>
            <li><a href="/registration">Регистрация</a></li>

        </ul>
    </div>
</header>

<br>
<br>
<br>
<form action="/login" method="post">
    <h3 style="text-indent:30px">
        Login<input type="text" name="username">
        <br>
    <br>
    Password<input type="password" name="password">
        <br>
        <br>
    <input type="submit" value="Ok" class="button">
    </h3>
</form>
</body>
</html>