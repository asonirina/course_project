<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<body>

<c:if test="${not empty errors}">
    <c:forEach var="err" items="${errors}">
        <div class="alert alert-danger fade in">
            <a class="close" data-dismiss="alert">×</a>
            <c:out value="${err}"/>
        </div>
    </c:forEach>
</c:if>
<div class="wrapper">
<form:form method="post" id="form" action="/e-Testing/admin/SaveStudent.html" commandName="student"
           role="form">

    <c:if test="${not empty student.id}">
        <input type="hidden" id="id" name="id"
               value="${student.id}"/>
    </c:if>

    <div class="form-group">
        <form:label path="firstName">Имя</form:label>
        <form:input path="firstName" value="${student.firstName}"
                    class="form-control" name="firstName" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="secondName">Фамилия</form:label>
        <form:input path="secondName" value="${student.secondName}"
                    class="form-control" name="secondName" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="form">Класс</form:label>
        <form:input type="number" min="6" max="11" path="form" value="${student.form}"
                    class="form-control" name="form" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="login">Email</form:label>
        <form:input type="email" path="login" value="${student.login}"
                    class="form-control" name="login" required="true"/>
    </div>
    <div class="form-group">
        <form:label path="password">Пароль</form:label>
        <form:password path="password" value="${student.password}"
                       class="form-control" name="password" required="true"/>
    </div>

    <div style="text-align: right">
        <input type="submit" class="btn-primary btn" value="Сохранить"/>
        <a class="btn" href="<c:url value="/e-Testing/admin/StudentList.html"/>">Отмена</a>
    </div>


</form:form>
</div>
</body>
</html>