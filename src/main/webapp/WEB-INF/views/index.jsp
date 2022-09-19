<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/20/2022
  Time: 3:42 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body id="guitar">
<h1>List Product</h1>
<a class="create" th:href="@{/create}">Create guitar</a>

<div class="grid">
    <div class="grid__row">
        <div class="grid__column-2 container" th:each="guitar : ${guitarList}">
            <a class="container__link" th:href="@{/details/__${guitar.id}__}">
                <div class="img"><img th:src="@{'/image/' + ${guitar.img}}" alt=""></div>
                <div class="name" th:text="${guitar.name}"></div>
                <div class="price">
                    <span class="price__title">Giá: </span>
                    <span th:text="${guitar.price}"></span>
                    <span>VND</span>
                </div>
                <div class="action">
                    <a class="update" th:href="@{/update/__${guitar.id}__}">Update</a>
                    <a class="delete" th:href="@{/delete/__${guitar.id}__}">Delete</a>

                </div>
            </a>

        </div>

    </div>
</div>

</body>
