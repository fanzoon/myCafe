<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New contact</title>
</head>
<body>

<form method="POST" action="/addContact">
    <p>
        <label for="contactType">Выберите тип контакта</label>
        <select name="contactType" id="contactType">
            <#list contactTypes as contactType>
            <option value="${contactType.id}">${contactType.name}</option>
        </#list>
        </select>
    </p>
    <p>
        <label for="name">Введите контакт</label>
        <input type="text" name="name" id="name"/>
    </p>

    <p>
        <input type="submit" value="Добавить контакт">
    </p>

</form>

</body>
</html>