<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New contact</title>
    <style>
        body {
            background-color: #faf0e6;
            margin: auto;
        }
    </style>
</head>
<body>



<form action="/admin/dish/addContactForAdmin" method="post">
    Выберите тип контакта:<br>
    <select name="contactType">
        <#list contactTypes as contactType>
        <option value="${contactType.name}">${contactType.name}</option>
    </#list>
    </select>
    <br><br>
    Введите контакт:<br>
    <@spring.formInput  "contactDTO.name"/>
    <@spring.showErrors "<br>"/>

    <br>
    <br>
    <br>

    <input type="submit" value="Добавить контакт">
</form>

</body>
</html>