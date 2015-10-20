<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>

    <script src="/js/validate.min.js" type="text/javascript"></script>
</head>
<body>

<c:if test="${not empty errors}">
    <c:forEach var="err" items="${errors}">
        <div class="alert alert-danger fade in">
            <a class="close" data-dismiss="alert">×</a>
            <c:out value="${err}"/>
        </div>
    </c:forEach>
</c:if>

<form:form method="post" id="form" action="/e-Testing/admin/SaveStudent.html" commandName="student"
           role="form">

    <c:if test="${not empty student.id}">
        <input type="hidden" id="id" name="id"
               value="${student.id}"/>
    </c:if>

    <div class="form-group">
        <form:label path="firstName">Имя</form:label>
        <form:input path="firstName" value="${student.firstName}"
                    class="form-control" name="firstName"/>
    </div>
    <div class="form-group">
        <form:label path="secondName">Фамилия</form:label>
        <form:input path="secondName" value="${student.secondName}"
                    class="form-control" name="secondName"/>
    </div>
    <div class="form-group">
        <form:label path="form">Класс</form:label>
        <form:input path="form" value="${student.form}"
                    class="form-control" name="form"/>
    </div>
    <div class="form-group">
        <form:label path="login">Email</form:label>
        <form:input path="login" value="${student.login}"
                    class="form-control" name="login"/>
    </div>
    <div class="form-group">
        <form:label path="password">Пароль</form:label>
        <form:password path="password" value="${student.password}"
                       class="form-control" name="password"/>
    </div>

    <div style="text-align: right">
        <input type="submit" class="btn-primary btn" value="Сохранить"/>
        <a class="btn" href="<c:url value="/e-Testing/admin/StudentList.html"/>">Отмена</a>
    </div>


</form:form>
</body>
</html>