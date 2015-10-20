<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script src="/js/validate.min.js" type="text/javascript"></script>
</head>
<body>

<c:if test="${not empty message}">
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert">×</a>
        <c:out value="${message}"/>
    </div>
</c:if>

<div class="wrapper">
    <form method="post" id="form" role="form">
        <div class="form-group">
            <label for="oldPassword">Старый пароль</label>
            <input name="oldPassword" id="oldPassword" class="form-control" type="password"
                   placeholder="Enter old password"/>
        </div>
        <div class="form-group">
            <label for="password1">Новый пароль</label>
            <input name="password1" id="password1" class="form-control" type="password" placeholder="Enter new password"/>
        </div>

        <div class="form-group">
            <label for="password2">Повторите пароль</label>
            <input name="password2" id="password2" class="form-control" type="password" placeholder="Repeat new password"/>
        </div>

            <input type="submit" class="btn btn-primary" value="Сменить пароль" />
    </form>
</div>
</body>
</html>