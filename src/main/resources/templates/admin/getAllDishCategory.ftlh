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

<h2>Список категорий блюд</h2>
<table>
    <thead>
    <tr>
        <th>Наименование категории</th>
        <th>Позиция категории</th>
        <th>Посмотреть список блюд</th>
        <th>Изменить категорию</th>
        <th>Изменить статус(активно/неактивно)</th>
    </tr>
    </thead>
    <tbody>
    <#list allDishCategory as dishCategory>
    <tr>
        <th>${dishCategory.name}</th>
        <th>${dishCategory.numberPriority}</th>
        <th>
            <a href="/admin/dish/getAllDishOfCategory/${dishCategory.id}">Посмотреть список блюд</a>
        </th>
        <th>
            <a href="/admin/dish/updateCategory/${dishCategory.id}">Изменить категорию</a>
        </th>
        <th>
            <#if dishCategory.activity>
            активно
            <#else> неактивно
        </#if>

            <form method="post" action="/admin/dish/changeStatusDishCategory/${dishCategory.id}">
                <input type="submit" value="Изменить активность">
            </form>
        </th>
    </tr>
    </#list>
    </tbody>
</table>

<th>
    <a href="/admin/dish/addCategory">Добавить категорию блюд</a>
</th>

</body>
</html>