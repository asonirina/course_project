<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script src="/js/validate.min.js" type="text/javascript"></script>
    <script src="/js/init.js" type="text/javascript"></script>
</head>
<body>

<c:if test="${not empty errors}">
    <div id="output" class="errorblock">
        <c:forEach var="errors" items="${errors}">
            <c:out value="${errors}"/><br>
        </c:forEach>
    </div>
</c:if>
<div class="wrapper">
<form:form method="post" id="form" class="blocks" action="/e-Testing/SaveStudent.html" commandName="student">

    <c:if test="${not empty student.id}">
        <input type="hidden" id="id" name="id"
               value="${student.id}"/>
    </c:if>

    <p>
    <form:label path="firstName">Имя</form:label>
    <form:input path="firstName" value="${student.firstName}"
                class="text" name="firstName"/>
    </p>
    <p>
    <form:label path="secondName">Фамилия</form:label>
    <form:input path="secondName" value="${student.secondName}"
                class="text" name="secondName"/>
    </p>
    <p>
    <form:label path="form">Класс</form:label>
    <form:input path="form" value="${student.form}"
                class="text" name="form" />
    </p>
    <p>
    <form:label path="login">Логин</form:label>
    <form:input path="login" value="${student.login}"
                class="text" name="login"/>
    </p>
    <p>
    <form:label path="password">Пароль</form:label>
    <form:password path="password" value="${student.password}"
                   class="text" name="password"/>
    </p>
    <p>
    <br>
    <div style="text-align: center">
        <input type="submit" class="btn" value="Сохранить" style="margin-left: 540px"/>
    <a href="<c:url value="/e-Testing/StudentList.html"/>"><input type="button"
            value="Отмена"
            name="canceled" class="btn" style="margin-left: 10px"/></a>
         <%--<a href="<c:url value="/e-Testing/ViewStudent.html?id=${student.id}"/>"><input type="button"--%>
                                                                                       <%--value="Отмена"--%>
                                                                                       <%--name="canceled" class="btn"/></a>--%>
    </div>
    </p>

</form:form>
</div>
</body>
</html>