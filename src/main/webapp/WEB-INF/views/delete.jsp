<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/20/2022
  Time: 3:40 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Delete guitar</title>
</head>
<body>
<h1>Delete guitar</h1>
<h2>Are you sure?</h2>
<p>
    <a href="/home">Home</a>
</p>
<form th:action="@{/delete}" th:object="${guitar}" method="post">
    <input th:type="hidden" name="id" th:field="*{id}">
    <table>
        <tr>
            <td>Name:</td>
            <td th:text="${guitar.name}"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td th:text="${guitar.price}"></td>
        </tr>
        <tr>
            <td>Img:</td>
            <td th:text="${guitar.img}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Delete guitar"></td>
        </tr>
    </table>
</form>
</body>
</html>
