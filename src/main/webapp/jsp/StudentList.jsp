<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<form action="/e-Testing/DeleteStudent" method="post">
    <c:forEach var="student" items="${studentList}">

        <label>Имя</label>
        <span style="margin-left: 100px"><c:out value="${student.firstName}"/></span><br><br>
        <label>Фамилия</label>
        <span style="margin-left: 65px"><c:out value="${student.secondName}"/></span><br><br>
        <label>Класс</label>
        <span style="margin-left: 88px"><c:out value="${student.form}"/></span><br><br>

        <div style="text-align: end;">
            <a href="<c:url value="/e-Testing/ViewStudent?id=${student.id}"/>"><input type="button"
                                                                        value="Посмотреть"
                                                                        name="view" class="inputStyle"/></a>
            <a href="<c:url value="/e-Testing/EditStudent?id=${student.id}"/>"><input type="button"
                                                                                        value="Редактировать"
                                                                                        name="edit" class="inputStyle"/></a>

            <%--<input type="checkbox" name="id" value=${student.id}><br><br>--%>
        </div>

    </c:forEach>
    <%--<div style="text-align: end">--%>
        <%--<input type="submit" class="inputStyle" onclick="return confirm('Вы действительно хотите удалить этих пользователей?')"--%>
               <%--value="Удалить"/>--%>
    <%--</div>--%>
</form>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/StudentList" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>