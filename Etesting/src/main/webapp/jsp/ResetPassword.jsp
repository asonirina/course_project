<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<body>

<c:if test="${not empty message}">
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert">×</a>
        <c:out value="${message}"/>
    </div>
</c:if>

<div class="wrapper">
    <form method="post" id="form" class="blocks">

        <p>
            <c:out value="Новый пароль"/>
            <input name="password1" id="password1" class="text" type="password" style="margin-left: 40px;"/>
        </p>
        <p>
            <c:out value="Повторите пароль"/>
            <input name="password2" id="password2" class="text" type="password" style="margin-left: 13px;" /><br><br>
        </p>
        <p>
            <input type="submit" class="btn btn-default" value="Сменить пароль" style="margin-left: 320px;"/>
        </p>
    </form>
</div>
</body>
</html>