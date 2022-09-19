<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/20/2022
  Time: 3:39 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head >
    <meta charset="UTF-8">
    <title>Create guitar</title>
</head>

<body>
<h1>Create Guitar</h1>
<p>
    <a href="/home">Guitar list</a>
</p>

<form th:action="@{/create}" th:object="${guitar}" method="post" novalidate="novalidate" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" th:field="${guitar.name}" /></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" th:field="${guitar.price}" value=""/></td>
        </tr>
        <tr>
            <td>Img:</td>
            <td><input type="file" th:field="${guitar.img}" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create guitar"></td>
        </tr>
    </table>
</form>

</body>
</html>
