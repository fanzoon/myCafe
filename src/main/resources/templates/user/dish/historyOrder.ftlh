<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New CategoryOfDish</title>
    <link rel="stylesheet" href="css/styles.css">

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
        button {
            font-size: 20px;
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
            <li><a href="/userSetting"><< Вернуться назад</a></li>
            <li><a href="/">Главная</a></li>
            <li>
                <div class="dropdown">
                    <button class="dropbtn">${user.name}</button>
                    <div class="dropdown-content">
                        <a href="/userSetting">Личный кабинет</a>
                        <a href="/logout">Выйти</a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</header>

<h1 align ="center">История заказов</h1>
<table>
    <thead>
    <tr>
        <th>Номер заказа</th>
        <th>Тип доставки</th>
        <th>Тип оплаты</th>
        <th>Сумма заказа</th>
        <th>Дата заказа</th>
    </tr>
    </thead>
    <tbody>
    <#list orderHistoryDTOList as orderHistory>
    <tr>
        <th><a href="/historyOfOrders/${orderHistory.number}">${orderHistory.number}</a></th>
        <th>${orderHistory.deliveriesType}</th>
        <th>${orderHistory.paymentType}</th>
        <th>${orderHistory.amount}</th>
        <th>${orderHistory.dateOfOrdering}</th>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>