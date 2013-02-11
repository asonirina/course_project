<%@ page import="by.bsu.project.model.SpringUser" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="home"><a href="<c:url value="/e-Testing/MainStudentPage.html"/>"></a></div>

<%
    SpringUser user = (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long id = user.getId();
    String url = "/e-Testing/UploadProgram.html?id=" + String.valueOf(id);
%>
<ul>
    <li><a href="<c:url value="<%=url%>"/>">Проверить программу<span>Загрузить</span></a></li>
    <li style="margin-left: 420px"><a href="<c:url value="/e-Testing/ChangePassword.html"/>">Сменить пароль<span>Сменить</span></a></li>
    <li><a href="<c:url value="/e-Testing/Logout/Success.html"/>">Выйти из программы<span>Выйти</span></a></li>
</ul>

</body>
</html>