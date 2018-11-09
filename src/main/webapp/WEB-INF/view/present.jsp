<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html lang="en"
xmlns:display="http://www.w3.org/1999/xhtml"
xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <fmt:setBundle basename="messages_${sessionScope.lang}" var="lang"/>
    <fmt:requestEncoding value="UTF-8" />
    <title><fmt:message key="PresentPage" bundle="${lang}"/></title>
</head>
<body>


<h2><fmt:message key="SortLabel" bundle="${lang}"/></h2>
<form method = "get" action="">
    <input type="hidden" name="command" value="Sort">

    <input type="radio" name="sort" value="sortByQTY"><fmt:message key="sortByQTY" bundle="${lang}"/><br>
    <input type="radio" name="sort" value="sortByWeight"><fmt:message key="sortByWeight" bundle="${lang}"/><br>
    <input type="radio" name="sort" value="sortBySugarContent"><fmt:message key="sortBySugarContent" bundle="${lang}"/><br>
    <input type="radio" name="sort" value="sortByPrice"><fmt:message key="sortByPrice" bundle="${lang}"/><br>

    <button type="submit"><fmt:message key="Sort" bundle="${lang}"/></button>
</form>


<h2><fmt:message key="PresentContent" bundle="${lang}"/>:</h2>

    <label style="width: 200px"><fmt:message key="Name" bundle="${lang}"/></label>
    <label style="width: 100px"><fmt:message key="WeightG" bundle="${lang}"/></label>
    <label style="width: 120px"><fmt:message key="SugarContent" bundle="${lang}"/>, %</label>
    <label style="width: 100px"><fmt:message key="PriceUAH" bundle="${lang}"/></label>
    <label style="width: 200px"><fmt:message key="QuantityUnit" bundle="${lang}"/></label>
    <hr />


<c:forEach var="sweety" items="${sessionScope.presentContent}">
        <label style="width: 200px" ><c:out value="${sweety.key.name}"/></label>
        <label style="width: 100px" ><c:out value="${sweety.key.weight}"/></label>
        <label style="width: 120px" ><c:out value="${sweety.key.sugarContent}"/></label>
        <label style="width: 100px" ><c:out value="${sweety.key.priceUAH}"/></label>
        <label style="width: 100px" ><c:out value="${sweety.value}"/></label>
    <br />
</c:forEach>

    <br />
    <h3><fmt:message key="TotalWeight" bundle="${lang}"/>: <c:out value="${sessionScope.weight}"/></h3>
    <h3><fmt:message key="TotalAmount" bundle="${lang}"/>: <c:out value="${sessionScope.price}"/></h3>


</body>
</html>
