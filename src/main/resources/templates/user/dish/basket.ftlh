<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New CategoryOfDish</title>
    <link rel="stylesheet" href="css/styles.css"></link>

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
            font-size:23px;
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
    <div id="menu">
        <ul>
            <li><a href="/">Главная</a></li>
            <li><a href="/userSetting">Личный кабинет</a></li>
            <li><a href="/admin/dish/getAllDishCategory">Для администратора</a></li>
            <li><a href="/logout">Выйти</a></li>
        </ul>
    </div>
</header>

<h1 align ="center">Мой заказ</h1>

<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Вес г. / объем мл.</th>
        <th>Цена, руб.</th>
        <th>Количество</th>
        <th>Увеличить/<br>Уменьшить</th>
        <th>Сумма, руб.</th>
    </tr>
    </thead>

    <tbody>
    <#list listBasketDTO as basket>
    <tr>
        <th>
            <a href="/infoDish/${basket.dishId}">${basket.name}</a>
        </th>
        <th>${basket.weight}</th>
        <th>${basket.price}</th>
        <th>${basket.count}</th>
        <th align ="center">
            <form action="/addDishFromOrder/${basket.dishId}" method="post">
                <input type="submit" value=" + " class="button2">
            </form>
            <form action="/removeDishFromOrder/${basket.dishId}" method="post">
                <input type="submit" value=" - " class="button2">
            </form>
        </th>
        <th>${basket.amount}</th>
    </tr>
    </#list>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th><h1>Итого:</h1></th>
        <th><h2>${totalAmount} руб.</h2></th>
    </tr>
    </tbody>
</table>

<br>
<br>

<div align="center">
    <#if listBasketDTO?size!=0>
    <#if order.id??>
    <form action="/ordering/${order.id}" method="get">
        <input type="submit" value="Оформить заказ" class="button">
    </form>
</#if>
</#if>
</div>

<br>

</body>
</html>