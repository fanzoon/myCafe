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
    </style>

</head>
<body>

<h2>Список блюд в категории</h2>
<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Цена, руб.</th>
    </tr>
    </thead>
    <tbody>
    <#list allDishesIntoDishCategory as dish>
    <tr>
        <th>${dish.name}</th>
        <th>${dish.description}</th>
        <th>${dish.price}</th>
    </tr>
    </#list>
    </tbody>
</table>

<p>
    <a href="/admin/dish/add">Добавить блюдо в меню</a>
</p>

<p>
    <a href="/admin/dish/getAllDishCategory">Вернуться назад</a>
</p>

</body>
</html>