<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <div class="home"><a href="<c:url value="/e-Testing/admin/MainPage.html"/>"></a></div>

    <ul>
        <li><a href="<c:url value="/e-Testing/admin/EditStudent.html"/>">Добавить ученика<span>Добавить</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html"/>">Список учеников<span>Список</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html"/>">Список заданий<span>Список</span></a></li>
        <li><a href="<c:url value="/e-Testing/admin/ShowGraph.html"/>">Проверка<span>Плагиат</span></a></li>
        <li style="margin-left: 70px"><a href="<c:url value="/e-Testing/admin/ChangePassword.html"/>">Сменить пароль<span>Сменить</span></a></li>
        <li><a href="<c:url value="/e-Testing/Logout/Success.html"/>">Выйти из программы<span>Выйти</span></a></li>
    </ul>

</body>
</html>