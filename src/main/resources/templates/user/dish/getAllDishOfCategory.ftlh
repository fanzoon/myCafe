<!DOCTYPE html>
<html xmlns:padding="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>New CategoryOfDish</title>
    <link rel="stylesheet" href="/templates/assets/css/style.css">
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
        .button {
            height:75px;
            width: 200px;
            border-radius: 10px;
            background:#DCDCDC;
            cursor:pointer;
            font-size:1vw;
        }

        .button2 {
            height:20px;
            width: 30px;
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
<body>
<header style="margin: 0; padding: 0; ">
    <div id="menu"> <!-- Меню -->
        <ul>
            <li ><a href="/">Главная</a></li>
            <li><a href="/basket">Корзина</a></li>
            <li><a href="/userSetting">Личный кабинет</a></li>
            <li><a href="/admin/dish/getAllDishCategory">Для администратора</a></li>
        </ul>
    </div>
</header>

<h1 align ="center">${dishCategory.name}</h1>

<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Цена, руб.</th>
        <th>Добавить блюдо в заказ</th>
    </tr>
    </thead>
    <tbody>
    <#list allDishesIntoDishCategory as dish>
    <tr>
        <th>
            <a href="/infoDish/${dish.id}">${dish.name}</a>
            </th>
        <th>${dish.description}</th>
        <th>${dish.price}</th>
        <th>
            <form action="/addDishToOrder/${dish.id}" method="post">
                <input type="submit" value="Добавить в заказ">
            </form>
        </th>
    </tr>
    </#list>
    </tbody>
</table>

<br>
</body>
</html>