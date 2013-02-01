<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<ul>
    <li><a href="<c:url value="/e-Testing/StudentList"/>">Посмотреть список студентов</a></li>
    <li><a href="<c:url value="/e-Testing/EditStudent"/>">Добавить студента</a></li>
</ul>
</body>
</html>