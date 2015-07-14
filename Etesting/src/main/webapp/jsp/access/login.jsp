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
    <div class="errorblock"><c:out value="${message}"/></div>
    </c:if>

    <c:if test="${not empty alert}">
        <div class="alertblock"><c:out value="${alert}"/></div>
    </c:if>

    <a href="http://oauth.vk.com/authorize?client_id=4994933&redirect_uri=whispering-refuge-5133.herokuapp.com/e-Testing&response_type=code" title="Зайти через ВКонтакте">Зайти через ВКонтакте</a>

	<form id="loginForm" action="j_spring_security_check" method="post" >
        <div class="field">
            <label for="j_username">Email:</label>
            <div class="input"><input id="j_username" name="j_username" type="text"/></div>
        </div>
        <div class="field">
            <a href="javascript:forgot()" id="forgot">Забыли пароль?</a>
            <label for="j_password">Пароль:</label>
            <div class="input"><input id="j_password" name="j_password" type="password"/></div>
        </div>
        <div class="submit">
            <button type="submit" name="submit">
            <span>Войти</span>
            </button>
            <label id="remember"><input name="" type="checkbox" value=""/> Запомнить меня</label>
        </div>

	</form>

</body>
</html>