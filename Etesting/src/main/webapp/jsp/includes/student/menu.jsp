<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="home"><a href="<c:url value="/e-Testing/student/MainPage.html"/>"></a></div>

<ul>
    <li><a href="<c:url value="/e-Testing/student/UploadProgram.html"/>">Проверить программу<span>Загрузить</span></a></li>
    <li><a href="<c:url value="/e-Testing/student/UploadProgramsHistory.html"/>">Посмотреть историю<span>Посмотреть</span></a></li>
    <li><a href="<c:url value="/e-Testing/student/StudentTasks.html"/>">Список заданий<span>Список</span></a></li>
    <li style="margin-left: 215px"><a href="<c:url value="/e-Testing/student/ChangePassword.html"/>">Сменить пароль<span>Сменить</span></a></li>
    <li><a href="<c:url value="/e-Testing/Logout/Success.html"/>">Выйти из программы<span>Выйти</span></a></li>
</ul>

</body>
</html>