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
    <form method="post" id="form" role="form">
        <div class="form-group">
            <label for="oldPassword">Старый пароль</label>
            <input name="oldPassword" id="oldPassword" class="form-control" type="password"
                   placeholder="Enter old password" required/>
        </div>
        <div class="form-group has-feedback">
            <label for="password1">Новый пароль</label>
            <input name="password1" id="password1" class="form-control" type="password" placeholder="Enter new password" required/>
        </div>

        <div class="form-group">
            <label for="password2">Повторите пароль</label>
            <input name="password2" id="password2" class="form-control" type="password"
                   placeholder="Repeat new password" data-match="#password1" required/>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Сменить пароль" />
            </div>
    </form>
</div>
</body>
</html>