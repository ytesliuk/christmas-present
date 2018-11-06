<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en"
      xmlns:display="http://www.w3.org/1999/xhtml"
      xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Create present</title>
</head>
<body>

<form method="post" action="/constructor">
    <label style="width: 100px"> Weight </label>
    <input type="text" name="minWeight">
    <input type="text" name="maxWeight"></br>
    <label style="width: 100px"> Sugar content </label>
    <input type="text" name="minSugar">
    <input type="text" name="maxSugar"></br>
    <label style="width: 100px"> Price </label>
    <input type="text" name="minPrice">
    <input type="text" name="maxPrice"></label><br/>

    <button type="submit">Filter</button>
</form>
<form method="get" action="/constructor">
    <button type="submit">Reset</button>
</form>

<h1>Sweets:</h1>

<label style="width: 200px">Name</label>
<label style="width: 100px">Weight, g</label>
<label style="width: 120px">Sugar content, g</label>
<label style="width: 100px">Price</label>
<label style="width: 100px">Quantity</label>

<hr/>

<form method="post" action="/constructor">
    <c:forEach var="sweety" items="${requestScope.sweeties}">
        <label style="width: 200px">
            <c:out value="${sweety.name}"/>
        </label>
        <label style="width: 100px">
            <c:out value="${sweety.weight}"/>
        </label>
        <label style="width: 120px">
            <c:out value="${sweety.sugarContent}"/>
        </label>
        <label style="width: 100px">
            <c:out value="${sweety.price}"/>
        </label>
        <label style="width: 100px"><input type="text" name="qty"></label>
        <br/>
    </c:forEach>

</form>

</body>
</html>
