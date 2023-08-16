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

<form method="POST" action="/admin/dish/addCategory">
    <p>
        <label for="name">Название категории</label>
        <input type="text" name="name" id="name"/>
    </p>
    <p>
        <label for="numberPriority">Приоритет категории</label>
        <input type="number" name="numberPriority" id="numberPriority" min="1" max="10"/>
    </p>
    <input type="submit" value="Create!">
</form>

</body>
</html>