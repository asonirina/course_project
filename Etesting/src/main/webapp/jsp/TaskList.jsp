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

<c:if test="${form == 'admin'}">

    <div class="layer" style="margin-left: 483px">
        <p class="button heading">Классы: ${currentForm}</p>

        <div class="content" style="background: none">
            <a class="white-option button" href="<c:url value="/e-Testing/TaskList.html?form=6"/>">6</a>
            <a class="white-option button" href="<c:url value="/e-Testing/TaskList.html?form=7"/>">7</a>
            <a class="white-option button" href="<c:url value="/e-Testing/TaskList.html?form=8"/>">8</a>
            <a class="white-option button" href="<c:url value="/e-Testing/TaskList.html?form=9"/>">9</a>
            <a class="white-option button" href="<c:url value="/e-Testing/TaskList.html?form=10"/>">10</a>
            <a class="white-option button" href="<c:url value="/e-Testing/TaskList.html?form=11"/>">11</a>
        </div>
    </div>
    <br/>
    <br/>

    <div style="text-align: right;">
        <a href="<c:url value="/e-Testing/EditTask.html"/>">
            <input type="button" value="Добавить задание" name="edit" class="button"/></a>
    </div>
</c:if>

<c:forEach var="task" items="${taskList}">

    <span style="margin-left: 100px"><label>Название</label></span>
    <span style="margin-left: 100px"><c:out value="${task.programName}"/></span><br>
    <c:if test="${form != 'admin'}">
        <br/>
        <span style="margin-left: 100px"><label>Описание</label></span>
        <span style="margin-left: 100px"><c:out value="${task.description}"/></span><br>
    </c:if>


    <c:if test="${form == 'admin'}">
        <div style="text-align: right;">
            <a href="<c:url value="/e-Testing/EditTask.html?id=${task.id}"/>">
                <input type="button" value="Редактировать" name="edit" class="button"/></a>
        </div>
    </c:if>
    <HR color="#A8A8A8" size="1">
</c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/TaskList.html" var="pagedLink">
        <c:param name="page" value="~"/>
        <c:param name="form" value="${currentForm}"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>