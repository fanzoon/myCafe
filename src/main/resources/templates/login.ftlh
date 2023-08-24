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
            font-size: 1.1rem;
        }
        .button2 {
            height:25px;
            width: 55px;

        }

        a {
            text-decoration: none;
            color: rgba(134, 134, 200, 1);
            font-size: 17px;

        }
        a:hover {
            color: #dd4192;
        }
    </style>

</head>
<body align ="center">

<header style="margin: 0; padding: 0; ">
    <div id="menu">
        <ul fr>
            <li><a href="/registration"><h2>Регистрация</h2></a></li>

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
    <input type="submit" value="Войти" class="button2">
    </h3>
</form>
</body>
</html>