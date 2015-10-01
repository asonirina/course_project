<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <script type="text/javascript" src="../../js/validator.js"></script>
</head>
<body>
    <c:if test="${not empty message}">
    <div class="errorblock"><c:out value="${message}"/></div>
    </c:if>

    <c:if test="${not empty alert}">
        <div class="alertblock"><c:out value="${alert}"/></div>
    </c:if>


</body>
</html>