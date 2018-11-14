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
    <title><fmt:message key="ConstructorPage" bundle="${lang}"/></title>


</head>
<body>


<h2><fmt:message key="FilterLabel" bundle="${lang}"/></h2>


<form method="get" action="">
    <input type="hidden" name="command" value="Filter">

    <label style="width: 150px"><fmt:message key="WeightG" bundle="${lang}"/></label>
    <input type="text" name="minWeight">
    <input type="text" name="maxWeight"><br/>
    <label style="width: 150px"><fmt:message key="SugarContent" bundle="${lang}"/>, %</label>
    <input type="text" name="minSugar">
    <input type="text" name="maxSugar"><br/>
    <label style="width: 150px"><fmt:message key="PriceUAH" bundle="${lang}"/></label>
    <input type="text" name="minPrice">
    <input type="text" name="maxPrice"><br/>
    <button type="submit"><fmt:message key="Filter" bundle="${lang}"/></button>
</form>
<form method="get" action="">
    <input type="hidden" name="command" value="Filter">

    <button type="submit"><fmt:message key="reset" bundle="${lang}"/></button>
</form>


<h2><fmt:message key="AddSweets" bundle="${lang}"/></h2>

<form method="get" action="">
    <input type="hidden" name="command" value="AddSweety">

    <label style="width: 150px"><fmt:message key="Name" bundle="${lang}"/>: </label> <input type="text" name="name"><br/>
    <label style="width: 150px"><fmt:message key="WeightG" bundle="${lang}"/>: </label> <input type="text" name="weight"><br/>
    <label style="width: 150px"><fmt:message key="SugarContent" bundle="${lang}"/>, %: </label> <input type="text" name="sugarContent"><br/>
    <label style="width: 150px"><fmt:message key="PriceUAH" bundle="${lang}"/>: </label> <input type="text" name="price"><br/>
    <button type="submit"><fmt:message key="Add" bundle="${lang}"/></button><br/>

</form>

<h2><fmt:message key="AvailableSweets" bundle="${lang}"/></h2>

<form method="get" action="">
    <input type="hidden" name="command" value="CreatePresent">

    <label style="width: 200px"><fmt:message key="Name" bundle="${lang}"/></label>
    <label style="width: 100px"><fmt:message key="WeightG" bundle="${lang}"/></label>
    <label style="width: 120px"><fmt:message key="SugarContent" bundle="${lang}"/>, %</label>
    <label style="width: 100px"><fmt:message key="PriceUAH" bundle="${lang}"/></label>
    <label style="width: 200px"><fmt:message key="QuantityUnit" bundle="${lang}"/></label>
    <button type="submit"><fmt:message key="Create" bundle="${lang}"/></button>
    <hr/>

    <c:forEach var="sweety" items="${sessionScope.items}">
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
