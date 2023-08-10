<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update dish</title>
</head>
<body>

<form method="POST" action="/admin/dish/updateDish" enctype="multipart/form-data">
    <p>
    <input type="hidden" name="id" value="${dish.id}"/>
    </p>

    <p>
        <label for="name">Enter name</label>
        <input type="text" name="name" value="${dish.name}" id="name"/>
    </p>
    <p>
        <label for="description">Enter description</label>
        <input type="text" name="description" value="${dish.description}" id="description"/>
    </p>
    <p>
        <label for="weight">Enter weight</label>
        <input type="number" name="weight" value="${dish.weight}" id="weight"/>
    </p>
    <p>
        <label for="price">Enter price</label>
        <input type="number" name="price" value="${dish.price}" id="price" step="0.01"/>
    </p>
    <p>
        <label for="dishCategory">Enter dish Category</label>
        <select name="dishCategory" id="dishCategory">
            <#list categories as category>
            <option value="${category.id}">${category.name}</option>
        </#list>
        </select>
    </p>
    <p>
        <label for="file">Enter file</label>
        <input type="file" name="file" id="file"/>
    </p>
    <p>
        <input type="submit" value="Create!">
    </p>

</form>

</body>
</html>