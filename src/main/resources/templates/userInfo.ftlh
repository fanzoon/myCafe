<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>
   Имя: ${user.name}
</p>
<p>
   Фамилия: ${user.surName}
</p>
<p>
   Логин: ${user.login}
</p>
<p>
   День рождения: ${user.birthday}
</p>
<p>
    <h4>Контакты</h4>
    <#list contacts as contact>
    ${contact.contactType.name}: ${contact.name} <br>
</#list>
</p>
<a href="/addContact">Добавить контакт</a> <br>
<br>

<a href="/"><h2>Вернуться на главную страницу</h2></a>

</body>
</html>