<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New dish</title>
</head>
<body>

<form method="POST" action="/admin/dish/add" object="${dish}">
    <p>
        <label for="name">Enter name</label>
        <input type="text" name="${dish.name}" id="name"/>
    </p>
    <p>
        <label for="description">Enter description</label>
        <input type="text" name="#{dish.description}" id="description"/>
    </p>
    <p>
        <label for="price">Enter price</label>
        <input type="number" name="${dish.price}" id="price"/>
    </p>
    <input type="submit" value="Create!">
</form>

</body>
</html>