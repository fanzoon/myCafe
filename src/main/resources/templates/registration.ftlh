<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Form Data Binding and Validation</title>
    <style>
        body {
            background-color: #faf0e6;
            margin: auto;
        }
    </style>

</head>

<body>
<div align="center">
    <h2 style="color: #8686c8">Регистрация пользователя</h2>
    <br>
    <br>
    <br>

    <#if userDTO?? && noErrors??>
    Ваши отправленные данные<br>
    Имя: ${userDTO.name}<br>
    Фамилия: ${userDTO.surName}<br>
    Login: ${userDTO.login}<br>
    Password: ${userDTO.password}<br>
    ConfirmPassword: ${userDTO.confirmPassword}

    <div>
        <#else>
        <form action="/registration" method="post">
            Введите имя:<br>
            <@spring.formInput "userDTO.name"/>
            <@spring.showErrors  "<br>"/>
            <br><br>
            Введите фамилию:<br>
            <@spring.formInput  "userDTO.surName"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            Введите Login:<br>
            <@spring.formInput "userDTO.login"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            Введите password:<br>
            <@spring.formPasswordInput "userDTO.password"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            Подтвердите password:<br>
            <@spring.formPasswordInput "userDTO.confirmPassword"/>
            <@spring.showErrors "<br>"/>
            <br>
            <br>
            <br>

            <input type="submit" value="Зарегистрироваться">
        </form>
    </#if>
    </div>

</div>

</body>
</html>
