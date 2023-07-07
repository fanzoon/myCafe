<!DOCTYPE html>
<html>
<head>
    <title>Dishes</title>
    <style>
        table {
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {padding: 10px;
            border: 1px
            solid #ddd;
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
<h2>Список блюд</h2>
<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody>
    <#list dishes as dish>
    <tr>
        <th>${dish.name}</th>
        <th>${dish.description}</th>
        <th>${dish.price}</th>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>