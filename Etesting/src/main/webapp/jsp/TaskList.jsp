<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<div class="fixed-width">
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Классы: ${currentForm}
        <span class="caret"></span></button>
    <ul class="dropdown-menu">
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html?form=6"/>">6</a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html?form=7"/>">7</a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html?form=8"/>">8</a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html?form=9"/>">9</a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html?form=10"/>">10</a></li>
        <li><a href="<c:url value="/e-Testing/admin/TaskList.html?form=11"/>">11</a></li>
    </ul>
</div>

<br/>

<div style="text-align: right;">
    <a class="btn btn-default" href="<c:url value="/e-Testing/admin/EditTask.html"/>">Добавить задание</a>
</div>
<br/>

<c:forEach var="task" items="${taskList}">
    <div class="form-group">

        <div class="input-group">
            <span class="input-group-addon">Лабораторная № </span>
            <label style="border: none" class="form-control input"><c:out value="${task.programName}"/></label>
        </div>

        <div style="text-align: right;">
            <a class="btn" href="<c:url value="/e-Testing/admin/ViewTask.html?id=${task.id}"/>">Посмотреть</a>
            <a class="btn " href="<c:url value="/e-Testing/admin/EditTask.html?id=${task.id}"/>">&nbsp;&nbsp;Редактировать&nbsp;&nbsp;&nbsp;</a>
        </div>
        <HR color="#A8A8A8" size="1">
    </div>
</c:forEach>

<div class="paging">
    <c:url value="/e-Testing/admin/TaskList.html" var="pagedLink">
        <c:param name="page" value="~"/>
        <c:param name="form" value="${currentForm}"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>
</div>
</body>
</html>