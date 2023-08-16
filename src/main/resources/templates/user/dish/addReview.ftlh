<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ordering</title>
</head>
<body>

<form method="POST" action="/addReview">


    <p>
        <label>Ваш отзыв:</label>
        <textarea name="message" rows="4" cols="50"></textarea>
    </p>

    <p>
        <label>Оставьте оценку:</label>
        <input type="number" name="mark" min="1" max="5">
    </p>

    <p>
        <input type="hidden" name="dishId" value="${dishId}">
    </p>

    <p>
        <input type="submit" value="Оставить отзыв">
    </p>

</form>

</body>
</html>