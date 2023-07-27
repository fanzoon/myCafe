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

<form method="POST" action="/admin/dish/addCategory">
    <p>
        <label for="name">Enter name</label>
        <input type="text" name="name" id="name"/>
    </p>
    <p>
        <label for="numberPriority">Enter description</label>
        <input type="number" name="numberPriority" id="numberPriority" min="1" max="10"/>
    </p>
    <input type="submit" value="Create!">
</form>

<h2>Список категорий блюд</h2>
<table>
    <thead>
    <tr>
        <th>Наименование категории</th>
        <th>Приоритет категории</th>
        <th>Изменить категорию</th>
        <th>Посмотреть список блюд</th>

    </tr>
    </thead>
    <tbody>
    <#list allDishCategory as dishCategory>
    <tr>
        <th>${dishCategory.name}</th>
        <th>${dishCategory.numberPriority}</th>
        <th>
            <a href="/admin/dish/updateCategory/${dishCategory.id}">Изменить категорию</a>
        </th>
        <th>
            <a href="/admin/dish/getAllDishOfCategory/${dishCategory.id}">Посмотреть список блюд</a>
        </th>

    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>