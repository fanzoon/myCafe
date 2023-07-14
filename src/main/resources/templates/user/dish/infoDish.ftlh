<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить в заказ</title>
</head>
<body>

<h2>Информация о блюде</h2>

<b>Наименование:</b> ${dish.name} <br>
<b>Описание:</b> ${dish.description} <br>
<b>Цена:</b> ${dish.price} <br>

<form action="/addDishToOrder/${dish.id}" method="post">
    <input type="submit" value="Добавить в заказ">
</form>

<a href="/static">Вернуться к списку блюд</a>

</body>
</html>