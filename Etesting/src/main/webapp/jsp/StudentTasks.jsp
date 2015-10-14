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

<c:forEach var="task" items="${taskList}">

    <span style="margin-left: 100px"><label>Лабораторная №</label></span>
    <span style="margin-left: 100px"><c:out value="${task.programName}"/></span><br>
    <span style="margin-left: 100px"><label>Описание</label></span>
    <span style="margin-left: 100px"><c:out value="${task.description}"/></span><br>
    <HR color="#A8A8A8" size="1">
</c:forEach>

<div class="paging">
    <c:url value="/e-Testing/StudentTasks.html" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>