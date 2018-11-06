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

<form method = "post" action="/present">
    <input type="radio" name="sort" value="sortByQTY"> Sort by quantity<br>
    <input type="radio" name="sort" value="sortByWeight"> Sort by weight<br>
    <input type="radio" name="sort" value="sortBySugarContent"> Sort by sugar content<br>
    <input type="radio" name="sort" value="sortByPrice"> Sort by price<br>

    <button type="submit">Sort</button>
</form>


<h1>Sweets:</h1>

<label style="width: 200px">Name</label>
<label style="width: 100px">Weight, g</label>
<label style="width: 120px">Sugar content, g</label>
<label style="width: 100px">Price</label>
<label style="width: 100px">Quantity</label>

    <hr />


<c:forEach var="sweety" items="${requestScope.sweeties}">
        <label style="width: 200px" ><c:out value="${sweety.key.name}"/></label>
        <label style="width: 100px" ><c:out value="${sweety.key.weight}"/></label>
        <label style="width: 120px" ><c:out value="${sweety.key.sugarContent}"/></label>
        <label style="width: 100px" ><c:out value="${sweety.key.price}"/></label>
        <label style="width: 100px" ><c:out value="${sweety.value}"/></label>
    <br />
</c:forEach>

    <br />
    <h2>Total weight: <c:out value="${requestScope.weight}"/></h2>


</body>
</html>
