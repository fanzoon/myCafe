<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New CategoryOfDish</title>

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
        img {
            height: 220px;
            width: 330px;
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

<div align="center">
    <header style="margin: 0; padding: 0; ">
        <div id="menu">
            <ul>
                <li><a href="/admin/dish/getAllDishCategory"><< Назад</a></li>
                <li><a href="/admin/dish/mainAdmin">Главная</a></li>
                <li>
                    <div class="dropdown">
                        <button class="dropbtn">${user.login}</button>
                        <div class="dropdown-content">
                            <a href="/admin/dish/adminSetting">Личный кабинет</a>
                            <a href="/admin/dish/getAllDishCategory">Права администратора</a>
                            <a href="/logout">Выйти</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </header>

    <h1>${dishCategory.name}</h1>
    <table>
        <thead>
        <tr>
            <th>Наименование блюда</th>
            <th>Описание блюда</th>
            <th>Вес г. / объем мл.</th>
            <th>Цена, руб.</th>
            <th>Изменить блюдо</th>
            <th>Удалить блюдо</th>
            <th>Изменить статус<br>(активно/неактивно)</th>
            <th>Фото</th>
        </tr>
        </thead>
        <tbody>
        <#list allDishesIntoDishCategory as dish>
        <tr>
            <th>${dish.name}</th>
            <th>${dish.description}</th>
            <th>${dish.weight}</th>
            <th>${dish.price}</th>
            <th>
                <a href="/admin/dish/updateDish/${dish.id}">Внести изменения</a>
            </th>
            <th>
                <form action="/admin/dish/deleteDish/${dish.id}" method="post">
                    <input type="submit" value="Удалить блюдо">
                </form>
            </th>
            <th>
                <#if dish.activity>
                <h3 style="color: #71cb1a">внесено в меню</h3>
                <#else>
                <h3 style="color: #f02929" >изъято из меню</h3>
            </#if>
            <form method="post" action="/admin/dish/changeStatusDish/${dish.id}">
                <input type="submit" value="Изменить статус">
            </form>
            </th>


            <#if dish.imageId??>
            <th><p class="fig"><img src="/images/${dish.imageId}"></p></th>
        </#if>
        </#list>
        </tr>
        </tbody>
    </table>

    <h2>
        <a href="/admin/dish/add">Добавить блюдо в меню</a>
    </h2>
</div>



</body>
</html>