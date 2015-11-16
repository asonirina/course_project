<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
    <%--<div class="home"><a href="<c:url value="/e-Testing/admin/MainPage.html"/>"></a></div>--%>

    <ul>
        <li class="home"><a href="<c:url value="/e-Testing/admin/MainPage.html"/>"></a></li>
        <li><a href="<c:url value="/e-Testing/admin/EditStudent.html"/>">Добавить ученика<span>Добавить</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html"/>">Список учеников<span>Список</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html"/>">Список заданий<span>Список</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/Assignments.html"/>">Задачи<span>Таблица</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/Canvas.html"/>">Проверка<span>График</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/ShowGraph.html"/>">Проверка<span>Плагиат</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/ChangePassword.html"/>">Сменить пароль<span>Сменить</span></a></li>
        <li><a href="<c:url value="/e-Testing/Logout/Success.html"/>"><sec:authentication property="principal.username"/><span>Выйти</span></a></li>
    </ul>

</body>
</html>