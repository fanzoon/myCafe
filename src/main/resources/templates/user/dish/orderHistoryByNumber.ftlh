<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New CategoryOfDish</title>
    <link rel="stylesheet" href="css/styles.css"></link>

    <style>
        table {
            border-collapse: collapse;
            margin: 20px 0;
            margin: auto;
        }

        th, td {
            padding: 10px;
            border: 1px solid #5b5959;
        }

        th {
            font-weight: bold;
            text-align: center;
        }

        td:last-child {
            text-align: center;
        }

        body {
            background-color: #faf0e6;
            margin: auto;
        }

        .button {
            height:75px;
            width: 210px;
            border-radius: 10px;
            background:#DCDCDC;
            cursor:pointer;
            font-size:21px;
        }

        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 25px;
        }

        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
            font-size: 1.1rem;
        }
        a {
            text-decoration: none;
            color: rgba(134, 134, 200, 1);

        }
        a:hover {
            color: #dd4192;
        }

        thead {
            font-size: 1.4rem;
        }

        tbody {
            font-size: 1.2rem;
        }
        /*    */
        .dropbtn {
            background-color: #faf0e6;
            color: rgba(134, 134, 200, 1);
            padding: 16px;
            font-size: 16px;
            border: none;
            font-family: times new roman;
        }

        /* Контейнер <div> - необходим для размещения выпадающего содержимого */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Выпадающее содержимое (скрыто по умолчанию) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        /* Ссылки внутри выпадающего списка */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }
        /* Изменение цвета выпадающих ссылок при наведении курсора */
        .dropdown-content a:hover {background-color: #ddd;}

        /* Показать выпадающее меню при наведении курсора */
        .dropdown:hover .dropdown-content {display: block;}
    </style>
</head>
<body>
<header style="margin: 0; padding: 0; ">
    <div id="menu">
        <ul>
            <li><a href="/">Главная</a></li>
            <li><a href="/menuDish">Меню</a></li>
            <li><a href="/basket">Корзина</a></li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn">${user.name}</button>
                    <div class="dropdown-content">
                        <a href="/userSetting">Личный кабинет</a>
                        <a href="/historyOfOrders">История заказов</a>
                        <a href="/logout">Выйти</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</header>
<br>
<h1 align ="center">Заказ №:${orderId}</h1>

<table>
    <thead>
    <tr>
        <th>Наименование блюда</th>
        <th>Вес г. / объем мл.</th>
        <th>Цена, руб.</th>
        <th>Количество</th>
        <th>Сумма, руб.</th>
    </tr>
    </thead>

    <tbody>
    <#list listBasketDTO as basket>
    <tr>
        <th>
            <a href="/infoDish/${basket.dishId}">${basket.name}</a>
        </th>
        <th>${basket.weight}</th>
        <th>${basket.price}</th>
        <th>${basket.count}</th>
        <th>${basket.amount}</th>
    </tr>
    </#list>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th><h1>Итого:</h1></th>
        <th><h2>${totalAmount} руб.</h2></th>
    </tr>
    </tbody>
</table>


</body>
</html>