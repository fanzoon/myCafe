<!DOCTYPE html>
<html>
<head>
    <title>Dishes</title>
    <link rel="stylesheet" href="styles/style.css">
    <style>

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
        <th>Итого:</th>
        <th>${totalAmount}</th>
    </tr>
    </tbody>
</table>

<th>
    <a href="/admin/dish/getAllDishCategory">Для администратора</a>
</th>

</body>
</html>