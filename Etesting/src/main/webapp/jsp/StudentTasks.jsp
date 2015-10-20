<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<body>
<c:forEach var="task" items="${taskList}">
    <div class="form-group">

        <div class="input-group">
            <span style="width: 200px;" class="input-group-addon">Лабораторная № </span>
            <label style="border: none" class="form-control input"><c:out value="${task.programName}"/></label>
        </div>

        <div class="input-group">
            <span style="width: 200px;" class="input-group-addon">Описание</span>
            <label style="border: none" class="form-control input"><c:out value="${task.description}"/></label>
        </div>

        <HR color="#A8A8A8" size="1">
    </div>
</c:forEach>

<div class="paging">
    <c:url value="/e-Testing/student/StudentTasks.html" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>