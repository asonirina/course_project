<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="/js/results.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/results.css">
</head>
<body>

<span style="margin-left: 200px"><c:out value="Название"/></span>
<span style="margin-left: 118px"><c:out value="${task.programName}"/></span><br>
<span style="margin-left: 200px"><c:out value="Класс"/></span>
<span style="margin-left: 139px"><c:out value="${task.form}"/></span><br>
<label for="description" style="margin-left: 200px"><c:out value="Описание"/></label>
<span style="margin-left: 111px"><textarea id="description" rows="1" cols="30" class="text" disabled="true">${task.description}</textarea></span><br>

<HR color="#A8A8A8" size="1">

<c:forEach var="singleTest" items="${task.tests}">
    <label style="margin-left: 200px" for="dataIn">In</label>
    <span style="margin-left: 163px;"><textarea id="dataIn" rows="1" cols="30" class="text" disabled="true">${singleTest.dataInStr}</textarea></span><br>
    <label for="dataOut" style="margin-left: 200px">Out</label>
    <span style="margin-left: 153px"><textarea id="dataOut" rows="1" cols="30" class="text" disabled="true">${singleTest.dataOutStr}</textarea></span><br>


    <HR color="#A8A8A8" size="1">
</c:forEach>

<div class="paging">
    <c:url value="/e-Testing/admin/ViewTask.html?id=${task.id}" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

<div style="text-align: right">
    <a href="<c:url value="/e-Testing/admin/EditTask.html?id=${task.id}"/>"><input type="button"
                                                                                   value="Редактировать"
                                                                                   name="edit" class="button"/></a>
    <a href="<c:url value="/e-Testing/admin/DeleteTask.html?id=${task.id}&form=${task.form}"/>"><input type="button"
                                                                                     onclick="return confirm('Вы действительно хотите удалить эту запись?')"
                                                                                     value="Удалить"
                                                                                     name="delete" class="button"/></a>
</div>
</body>

</html>