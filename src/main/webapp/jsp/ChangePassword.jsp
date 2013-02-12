<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>
</head>
<body>

<c:if test="${not empty message}">
    <div class="errorblock"><c:out value="${message}"/></div>
</c:if>

<form method="post">
    <span style="margin-left: 200px;"><c:out value="Старый пароль"/></span>
    <input name="oldPassword" id="oldPassword" type="password" style="margin-left: 79px;"/><br>

    <span style="margin-left: 200px;"><c:out value="Новый пароль"/></span>
    <input name="password1" id="password1" type="password" style="margin-left: 85px;"/><br>

    <span style="margin-left: 200px;"><c:out value="Повторите новый пароль"/></span>
    <input name="password2" id="password2" type="password" style="margin-left: 20px;"/><br><br>

    <input type="submit" class="button" value="Сменить пароль" style="margin-left: 320px;"/>

</form>
</body>
</html>