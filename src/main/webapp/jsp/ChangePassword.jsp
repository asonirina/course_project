<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script src="/js/validate.min.js" type="text/javascript"></script>
    <script src="/js/init.js" type="text/javascript"></script>
</head>
<body>

<c:if test="${not empty message}">
    <div class="errorblock"><c:out value="${message}"/></div>
</c:if>

<div class="wrapper">
<form method="post" id="form" class="blocks">
    <p>
    <c:out value="Старый пароль"/>
    <input name="oldPassword" id="oldPassword" class="text" type="password" style="margin-left: 34px;"/>
    </p>
    <p>
    <c:out value="Новый пароль"/>
    <input name="password1" id="password1" class="text" type="password" style="margin-left: 40px;"/>
    </p>
    <p>
    <c:out value="Повторите пароль"/>
    <input name="password2" id="password2" class="text" type="password" style="margin-left: 17px;" /><br><br>
    </p>
    <p>
    <input type="submit" class="button" value="Сменить пароль" style="margin-left: 320px;"/>
    </p>
</form>
 </div>
</body>
</html>