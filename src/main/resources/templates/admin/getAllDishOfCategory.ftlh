<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New CategoryOfDish</title>

    <style>
        table {
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            font-weight: bold;
            text-align: left;
        }
        th:last-child,
        td:last-child {
            text-align: center;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
        img {
            height: 220px;
            width: 330px;
        }
        a {
            text-decoration: none;
            color: #8686c8;
        }
        a:hover {
            color: #d64d94;
        }
        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
        }
        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 25px;
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
            <li><a href="/admin/dish/getAllDishCategory"><< Назад</a></li>
            <li><a href="/">Главная</a></li>
            <li><a href="/logout">Выйти</a></li>
        </ul>
    </div>
</header>

<h2>${dishCategory.name}</h2>
<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Вес г. / объем мл.</th>
        <th>Цена, руб.</th>
        <th>Изменить блюдо</th>
        <th>Фото</th>
    </tr>
    </thead>
    <tbody>
    <#list allDishesIntoDishCategory as dish>
    <tr>
        <th>${dish.name}</th>
        <th>${dish.description}</th>
        <th>${dish.weight}</th>
        <th>${dish.price}</th>
        <th>
            <a href="/admin/dish/updateDish/${dish.id}">Внести изменения</a>
        </th>
        <#if dish.imageId??>
        <th><img src="/images/${dish.imageId}"></th>
        </#if>
    </#list>
    </tr>
    </tbody>
</table>

<h2>
    <a href="/admin/dish/add">Добавить блюдо в меню</a>
</h2>

</body>
</html>