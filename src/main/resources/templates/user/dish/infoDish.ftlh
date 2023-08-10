<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить в заказ</title>
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
            font-size: 1.1rem;
            display: inline-block;
            vertical-align: middle;
            margin-right: 25px;
        }

        header {
            display: flex;
            justify-content: left;
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

        .fig {
            text-align: center;
        }

        img {
            height: 400px;
            width: 600px;
        }
    </style>
</head>
<body>
<header style="margin: 0; padding: 0; ">
    <div id="info"> <!-- Меню -->
        <ul>
            <li><a href="/"> << Вернуться на главную</a></li>

        </ul>
    </div>
</header>
<br>

<#if imageId??>
<p class="fig">
<img src="/images/${imageId}">
</p>
</#if>

<br>
<h2 align="center">${dish.name}</h2>

<b>Наименование:</b> ${dish.name}<br>
<b>Вес:</b> ${dish.weight} гр./мл.<br>
<b>Описание:</b> ${dish.description} <br>
<b>Цена:</b> ${dish.price} <br>
<b>Категория блюда:</b> ${dish.dishCategory.name} <br>



<form action="/addDishToOrder/${dish.id}" method="post">
    <input type="submit" value="Добавить в заказ">
</form>

<a href="/addReview/${dish.id}">Оставить отзыв</a><br>

<a href="/getAllDishOfCategory/${dish.dishCategory.id}">Вернуться к списку блюд</a>

<h2>Отзывы:</h2>

<table>
    <thead>
    <tr>
        <th>Отзыв</th>
        <th>Оценка</th>
    </tr>
    </thead>
    <tbody>
    <#list reviewList as review>
    <tr>
        <th>${review.message}</th>
        <th>${review.mark}</th>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>