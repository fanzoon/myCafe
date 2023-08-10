<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        table {
            border-collapse: collapse;
            margin: 20px 0;
            margin: auto;
        }

        th, td {
            padding: 10px;
            border: 1px solid #5b5959;
        }

        th {
            font-weight: bold;
            text-align: center;
        }

        td:last-child {
            text-align: center;
        }

        body {
            background-color: #faf0e6;
            margin: auto;
        }

        button {
            font-size: 20px;
        }

        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 25px;
        }

        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
        }

        a {
            text-decoration: none;
            color: #8686c8;

        }
        a:hover {
            color: #d64d94;
        }

        thead {
            font-size: 1.4rem;
        }

        tbody {
            font-size: 1.2rem;
        }

    </style>
</head>
<body style="text-indent:20px">
<header style="margin: 0; padding: 0; ">
    <div id="menu">
        <ul>
            <li><a href="/">Главная</a></li>
            <li><a href="/basket">Корзина</a></li>
            <li><a href="/admin/dish/getAllDishCategory">Для администратора</a></li>
            <li><a href="/logout">Выйти</a></li>
        </ul>
    </div>
</header>

<h3>Данные профиля:</h3>

<p>
   Имя: ${user.name}
</p>
<p>
   Фамилия: ${user.surName}
</p>
<p>
   Логин: ${user.login}
</p>
<p>
   День рождения: ${user.birthday}
</p>
<br>
<p>
    <h3>Контакты:</h3>
</p>

    <#list contacts as contact>
<p>
    ${contact.contactType.name}: ${contact.name}
</p>
</#list>

<p>
    <a href="/addContact">Добавить контакт</a> <br>
</p>

</body>
</html>