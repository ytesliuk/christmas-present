<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <fmt:setBundle basename="messages_${sessionScope.lang}" var="lang"/>
    <fmt:requestEncoding value="UTF-8" />

    <title><fmt:message key="StartPage" bundle="${lang}"/></title>
</head>
<body>

<form method="get" action="">
    <input type="hidden" name="command" value="SessionStart">
    <input type="submit" name="lang" value="ua">
    <input type="submit" name="lang" value="en">
</form>


<form method="get" action="">
    <input type="radio" name="command" value="Constructor"><fmt:message key="CreatePresentOption" bundle="${lang}"/><br/>
    <input type="radio" name="command" value="GeneratePresent">
            <fmt:message key="GeneratePresentOption" bundle="${lang}"/>
            <input style="width: 50px" type="text" name="presentWeight">
            <fmt:message key="g" bundle="${lang}"/><br/><br/>
    <button type="submit"><fmt:message key="Create" bundle="${lang}"/></button>
</form>



</body>
</html>
