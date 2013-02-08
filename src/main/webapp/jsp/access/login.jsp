<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<body>
    <c:if test="${not empty message}">
    <div class="errorblock"><c:out value="${message}"/></div>
    </c:if>

	<form class="login-form" action="j_spring_security_check" method="post" >
	  <span style="margin-left: 230px"><label for="j_username">Логин:</label></span>
	  <span style="margin-left: 28px"><input id="j_username" name="j_username" type="text"/></span><br>

	  <span style="margin-left: 230px"><label for="j_password">Пароль:</label></span>
	  <span style="margin-left: 20px"><input id="j_password" name="j_password" type="password"/></span><br><br>

			<input type="submit" value="Авторизоваться" class="button" style="margin-left: 300px"/>
	</form>

</body>
</html>