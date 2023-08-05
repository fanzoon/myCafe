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

<h2>Меню</h2>
<table>
    <thead>
    <tr>
        <th>Наименование категории</th>
        <th>Позиция категории</th>
        <th>Посмотреть список блюд</th>
    </tr>
    </thead>
    <tbody>
    <#list dishCategories as dishCategory>
    <tr>
        <th>${dishCategory.name}</th>
        <th>${dishCategory.numberPriority}</th>
        <th>
            <a href="/getAllDishOfCategory/${dishCategory.id}">Посмотреть список блюд</a>
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
        <th>Цена, руб.</th>
        <th>Количество</th>
        <th>Сумма, руб.</th>
        <th>Уменьшить количество</th>
        <th>Увеличить количество</th>

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
        <th>
            <form action="/removeDishFromOrder/${basket.dishId}" method="post">
                <input type="submit" value=" - ">
            </form>
        </th>
        <th>
            <form action="/addDishFromOrder/${basket.dishId}" method="post">
                <input type="submit" value=" + ">
            </form>
        </th>
    </tr>
    </#list>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th>Итого:</th>
        <th>${totalAmount}</th>
        <th>
            <#if listBasketDTO?size!=0>
            <#if order.id??>
            <form action="/ordering/${order.id}" method="get">
                <input type="submit" value="Оформить заказ">
            </form>
            </#if>
            </#if>
        </th>

    </tr>
    </tbody>
</table>

<br>
<p>
    <a href="/userSetting">Личный кабинет</a>
</p>
<br>
<p>
    <a href="/admin/dish/getAllDishCategory">Для администратора</a>
</p>

</body>
</html>