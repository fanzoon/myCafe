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
        }
        a {
            text-decoration: none;
            color: #8686c8;

        }
        a:hover {
            color: #d64d94;
        }

        thead {
            font-size: 1.4rem;
        }

        tbody {
            font-size: 1.2rem;
        }
    </style>
</head>
<body>
<header style="margin: 0; padding: 0; ">
    <div id="menu">
        <ul>

            <li><a href="/userSetting"><< Вернуться назад</a></li>

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
        <th>${orderHistory.number}</th>
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