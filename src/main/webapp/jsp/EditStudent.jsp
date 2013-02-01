<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<form:form method="post" action="/e-Testing/SaveStudent" commandName="student">

    <c:if test="${not empty student.id}">
        <input type="hidden" id="id" name="id"
               value="${student.id}"/>
    </c:if>
        <form:label path="firstName">Имя</form:label>
        <form:input path="firstName" value="${student.firstName}" cssStyle="margin-left: 100px"/><br><br>

        <form:label path="secondName">Фамилия</form:label>
        <form:input path="secondName" value="${student.secondName}" cssStyle="margin-left: 67"/><br><br>

        <form:label path="form">Класс</form:label>
        <form:input path="form" value="${student.form}" cssStyle="margin-left: 88"/><br><br>

        <form:label path="login">Логин</form:label>
        <form:input path="login" value="${student.login}" cssStyle="margin-left: 85"/><br><br>

        <form:label path="password">Пароль</form:label>
        <form:password path="password" value="${student.password}" cssStyle="margin-left: 77"/><br><br>

        <input type="submit" class="inputStyle" value="Сохранить"/>
        <a href="<c:url value="/e-Testing/StudentList"/>"><input type="button" value="На главную" class="inputStyle"/></a>

</form:form>
</body>
</html>