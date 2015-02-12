<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<body>
    <c:if test="${not empty message}">
    <div class="errorblock"><c:out value="${message}"/></div>
    </c:if>


	<form id="loginForm" action="j_spring_security_check" method="post" >
        <div class="field">
            <label for="j_username">Логин:</label>
            <div class="input"><input id="j_username" name="j_username" type="text"/></div>
        </div>
        <div class="field">
            <a href="<c:url value="/e-Testing/Run.html"/>" id="forgot">Забыли пароль?</a>
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