<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ordering</title>
</head>
<body>

<form method="POST" action="/ordering">

    <p>
        <label for="deliveryType">Введите способ доставки</label>
        <select name="deliveryTypeId" id="deliveryType">
            <#list deliveries as delivery>
            <option value="${delivery.id}">${delivery.name}</option>
        </#list>
        </select>
    </p>
    <p>
        <label for="paymentTypeId">Введите способ оплаты</label>
        <select name="paymentTypeId" id="paymentTypeId">
            <#list payments as payment>
            <option value="${payment.id}">${payment.name}</option>
        </#list>
        </select>
    </p>

    <p>
        <label for="deliveryAddress">Введите адрес доставки</label>
        <input type="text" name="deliveryAddress" id="deliveryAddress"/>
    </p>
    <p>
        <input type="hidden" name="orderId" value="${orderId}">
    </p>

    <p>
        <input type="submit" value="Оформить заказ!">
    </p>

</form>

</body>
</html>