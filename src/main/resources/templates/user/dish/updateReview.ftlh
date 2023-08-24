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
        <input name="message" type="text" value="${review.message}"  rows="4" cols="50"></input>
    </p>

    <p>
        <label>Оставьте оценку:</label>
        <input type="number" value=${review.mark} name="mark" min="1" max="5">
    </p>

    <p>
        <input type="hidden" name="reviewId" value="${review.id}">
    </p>

    <p>
    <input type="hidden" name="dishId" value="${review.dish.id}">
    </p>

    <p>
        <input type="submit" value="Изменить отзыв">
    </p>

</form>

</body>
</html>