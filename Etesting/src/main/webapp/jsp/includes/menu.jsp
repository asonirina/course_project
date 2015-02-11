<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <div class="home"><a href="<c:url value="/e-Testing/MainAdminPage.html"/>"></a></div>

    <ul>
        <li><a href="<c:url value="/e-Testing/EditStudent.html"/>">Добавить нового ученика<span>Добавить</span></a></li>
        <li><a href="<c:url value="/e-Testing/StudentList.html"/>">Список студентов<span>Список</span></a></li>
        <li style="margin-left: 280px"><a href="<c:url value="/e-Testing/ChangePassword.html"/>">Сменить пароль<span>Сменить</span></a></li>
        <li><a href="<c:url value="/e-Testing/Logout/Success.html"/>">Выйти из программы<span>Выйти</span></a></li>
    </ul>

</body>
</html>