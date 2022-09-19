<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/20/2022
  Time: 3:43 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head >
    <meta charset="UTF-8">
    <title>Update product</title>
</head>

<body>
<h1>Update product</h1>
<p>
    <a href="/home">Home</a>
</p>

<form th:action="@{/update/__${guitar.id}__}" th:object="${guitar}" method="post" novalidate="novalidate" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" th:field="${guitar.name}" /></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" th:field="${guitar.price}" /></td>
        </tr>
        <tr>
            <td>Img:</td>
            <td><input type="file" id="input" th:field="${guitar.img}" /></td>

        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update guitar"></td>
        </tr>
    </table>

</form>

</body>


</html>
</table>

</body>
</html>
