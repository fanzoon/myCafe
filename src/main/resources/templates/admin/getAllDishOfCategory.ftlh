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
    </style>

</head>
<body>

<h2>${dishCategory.name}</h2>
<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Вес г. / объем мл.</th>
        <th>Цена, руб.</th>
        <th>Удалить блюдо</th>
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
            <form method="post" action="/deleteDish/${dish.id}">
                <input type="submit" value="Удалить блюдо">
            </form>
        </th>
        <#if dish.imageId??>
        <th><img src="/images/${dish.imageId}"></th>
        </#if>


    </#list>
    </tr>
    </tbody>
</table>

<p>
    <a href="/admin/dish/add">Добавить блюдо в меню</a>
</p>

<p>
    <a href="/admin/dish/getAllDishCategory">Вернуться к списку категорий</a>
</p>

</body>
</html>