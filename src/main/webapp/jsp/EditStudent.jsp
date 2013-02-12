<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>
</head>
<body>

<c:if test="${not empty errors}">
    <div id="output" class="errorblock">
        <c:forEach var="errors" items="${errors}">
            <c:out value="${errors}"/><br>
        </c:forEach>
    </div>
</c:if>

<form:form method="post" action="/e-Testing/SaveStudent.html" commandName="student" onsubmit="return checkAll();">

    <c:if test="${not empty student.id}">
        <input type="hidden" id="id" name="id"
               value="${student.id}"/>
    </c:if>

    <form:label path="firstName" cssStyle="margin-left: 200px;">Имя</form:label>
    <form:input path="firstName" value="${student.firstName}" cssStyle="margin-left: 101px"
                onkeypress="checkZeroLength('firstName','correctFirstName')"
                onfocus="checkZeroLength('firstName','correctFirstName')"
                onkeyup="checkZeroLength('firstName','correctFirstName')"/>
    <span class="span_info"><span id="correctFirstName"></span></span><br>

    <form:label path="secondName" cssStyle="margin-left: 200px;">Фамилия</form:label>
    <form:input path="secondName" value="${student.secondName}" cssStyle="margin-left: 71"
                onkeypress="checkZeroLength('secondName','correctSecondName')"
                onfocus="checkZeroLength('secondName','correctSecondName')"
                onkeyup="checkZeroLength('secondName','correctSecondName')"/>
    <span class="span_info"><span id="correctSecondName"></span></span><br>

    <form:label path="form" cssStyle="margin-left: 200px;">Класс</form:label>
    <form:input path="form" value="${student.form}" cssStyle="margin-left: 91"
                onkeypress="checkZeroLength('form','correctForm')"
                onfocus="checkZeroLength('form','correctForm')"
                onkeyup="checkZeroLength('form','correctForm')"/>
    <span class="span_info"><span id="correctForm"></span></span><br>

    <form:label path="login" cssStyle="margin-left: 200px;">Логин</form:label>
    <form:input path="login" value="${student.login}" cssStyle="margin-left: 89"
                onkeypress="checkZeroLength('login','correctLogin')"
                onfocus="checkZeroLength('login','correctLogin')"
                onkeyup="checkZeroLength('login','correctLogin')"/>
    <span class="span_info"><span id="correctLogin"></span></span><br>

    <form:label path="password" cssStyle="margin-left: 200px;">Пароль</form:label>
    <form:password path="password" value="${student.password}" cssStyle="margin-left: 81"
                   onkeypress="checkZeroLength('password','correctPassword')"
                   onfocus="checkZeroLength('password','correctPassword')"
                   onkeyup="checkZeroLength('password','correctPassword')"/>
    <span class="span_info"><span id="correctPassword"></span></span><br><br>

    <div style="text-align: center">
        <input type="submit" class="button" value="Сохранить"/>
        <a href="<c:url value="/e-Testing/ViewStudent.html?id=${student.id}"/>"><input type="button"
                                                                                       value="Отмена"
                                                                                       name="canceled" class="button"/></a>
    </div>
    <input type="hidden" name="check_zeroLength" id="check_zeroLength" value="0"/>
</form:form>
</body>
</html>