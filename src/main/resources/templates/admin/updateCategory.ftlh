<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New dish</title>
</head>
<body>

<form method="POST" action="/admin/dish/updateCategory/${dishCategory.id}">
    <p>
        <label for="name">Enter name</label>
        <input type="text" name="name" value=${dishCategory.name} id="name"/>
    </p>
    <p>
        <label for="numberPriority">Enter numberPriority</label>
        <input type="number" name="numberPriority" value=${dishCategory.numberPriority} id="numberPriority" min="1" max="10"/>
    </p>
    <input type="submit" value="Update!">
</form>

</body>
</html>

