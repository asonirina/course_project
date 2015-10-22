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
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert">×</a>
        <c:out value="${message}"/>
    </div>
</c:if>

<c:if test="${not empty alert}">
    <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <c:out value="${alert}"/>
    </div>
</c:if>
<div class="wrapper">
<form action="j_spring_security_check" method="post" role="form">
    <div class="form-group">
        <label for="j_username">Email:</label>
        <input id="j_username" name="j_username" type="email" class="form-control" placeholder="Enter email" required/>
    </div>
    <div class="form-group">
        <label for="j_password">Пароль:</label>
        <input class="form-control" id="j_password" name="j_password" type="password" placeholder="Enter password" required/>
        <a href="javascript:forgot()" id="forgot">Забыли пароль?</a>
    </div>
    <div class="checkbox">
        <label><input type="checkbox"> Запомнить меня</label>
    </div>

    <button type="submit" class="btn btn-default" name="submit">Войти</button>
</form>
  </div>
</body>
</html>