<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en"
      xmlns:display="http://www.w3.org/1999/xhtml"
      xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Constructor</title>
</head>
<body>


<form method="get" action="">
    <input type="hidden" name="command" value="Filter">

    <label style="width: 150px"> Weight, g </label>
    <input type="text" name="minWeight">
    <input type="text" name="maxWeight"></br>
    <label style="width: 150px"> Sugar content, % </label>
    <input type="text" name="minSugar">
    <input type="text" name="maxSugar"></br>
    <label style="width: 150px"> Price, UAH </label>
    <input type="text" name="minPrice">
    <input type="text" name="maxPrice"></label><br/>
    <button type="submit">Filter</button>
</form>
<form method="get" action="">
    <input type="hidden" name="command" value="CreatePresent">

    <button type="submit">Reset</button>
</form>


<h2>Add new sweet</h2>

<form method="get" action="">
    <input type="hidden" name="command" value="AddSweety">

    <label style="width: 150px">Name: </label> <input type="text" name="name"></br>
    <label style="width: 150px">Weight, g: </label> <input type="text" name="weight"></br>
    <label style="width: 150px">Sugar content, %: </label> <input type="text" name="sugarContent"></br>
    <label style="width: 150px">Price, UAH: </label> <input type="text" name="price"></br>
    <input type="submit" value="add" name="add"></br>

</form>

<h1>Sweets:</h1>

<form method="get" action="">
    <label style="width: 200px">Name</label>
    <label style="width: 100px">Weight, g</label>
    <label style="width: 120px">Sugar content, %</label>
    <label style="width: 100px">Price, UAH</label>
    <label style="width: 100px">Quantity</label>
    <label style="width: 100px">Quantity</label>

    <input type="submit" name="Create" value="Create">
    <input type="hidden" name="command" value="CreatePresent">
    <hr/>

    <c:forEach var="sweety" items="${sessionScope.sweeties}">
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
            <c:out value="${sweety.priceUAH}"/>
        </label>
        <label style="width: 100px">
            <input type="text" name="${sweety.name}">
         </label>
        <br/>
    </c:forEach>

</form>

</body>
</html>
