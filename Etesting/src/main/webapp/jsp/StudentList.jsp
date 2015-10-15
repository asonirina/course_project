<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="/js/results.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/results.css">
</head>
<body>

<div class="layer" style="margin-left: 485px">
    <p class="button heading">Классы: ${currentForm}</p>

    <div class="content" style="background: none">
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html"/>">Все</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html?form=6"/>">6</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html?form=7"/>">7</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html?form=8"/>">8</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html?form=9"/>">9</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html?form=10"/>">10</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/StudentList.html?form=11"/>">11</a>
    </div>
</div>
<br/>
<br/>

    <c:forEach var="student" items="${studentList}">

        <span style="margin-left: 100px"><label>Имя</label></span>
        <span style="margin-left: 100px"><c:out value="${student.firstName}"/></span><br>
        <span style="margin-left: 100px"><label>Фамилия</label></span>
        <span style="margin-left: 69px"><c:out value="${student.secondName}"/></span><br>
        <span style="margin-left: 100px"><label>Класс</label></span>
        <span style="margin-left: 89px"><c:out value="${student.form}"/></span><br>

        <div style="text-align: right;">
            <a href="<c:url value="/e-Testing/admin/ViewStudent.html?id=${student.id}"/>">
                <input type="button" value="Посмотреть" name="view" class="button"/></a>
            <a href="<c:url value="/e-Testing/admin/EditStudent.html?id=${student.id}"/>">
                <input type="button" value="Редактировать" name="edit" class="button"/></a>
        </div>
        <HR color="#A8A8A8" size="1">
    </c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/admin/StudentList.html" var="pagedLink">
        <c:param name="page" value="~"/>
        <c:param name="form" value="${currentForm}"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>