<!DOCTYPE html>
<html>
<head>
    <title>Dishes</title>
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
<h2>Список блюд</h2>
<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Цена</th>
        <th>Добавить в заказ</th>
    </tr>
    </thead>
    <tbody>
    <#list dishes as dish>
    <tr>
        <th>${dish.name}</th>
        <th>${dish.description}</th>
        <th>${dish.price}</th>
        <th>
            <a href="/infoDish/${dish.id}">Подробная информация</a>
        </th>
    </tr>
    </#list>
    </tbody>
</table>


<h2>Мой заказ</h2>

<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Описание блюда</th>
        <th>Цена</th>
        <th>Количество</th>
        <th>Сумма</th>
    </tr>
    </thead>

    <tbody>
    <#list listBasketDTO as basket>
    <tr>
        <th>${basket.name}</th>
        <th>${basket.description}</th>
        <th>${basket.price}</th>
        <th>${basket.count}</th>
        <th>${basket.amount}</th>
        </th>
    </tr>
    </#list>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th>Общая сумма</th>
        <th>${totalAmount}</th>
    </tr>
    </tbody>
</table>

</body>
</html>