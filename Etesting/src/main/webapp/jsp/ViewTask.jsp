<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

<body>

<div class="form-group">

    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Название </span>
        <label style="border: none" class="form-control input"><c:out value="${task.programName}"/></label>
    </div>

    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Класс </span>
        <label style="border: none" class="form-control input"><c:out value="${task.form}"/></label>
    </div>

    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Описание </span>
        <textarea id="description" rows="1" cols="30" class="form-control input"
                  disabled="true">${task.description}</textarea>
    </div>


    <HR color="#A8A8A8" size="1">

    <c:forEach var="singleTest" items="${task.tests}">
        <div class="input-group">
            <span class="input-group-addon" style="width: 100px;">In</span>
            <textarea class="form-control input" id="dataIn" rows="1" cols="30"
                      disabled="true">${singleTest.dataInStr}</textarea>
        </div>
        <div class="input-group">
            <span class="input-group-addon" style="width: 100px;">Out</span>
            <textarea class="form-control input" id="dataOut" rows="1" cols="30"
                      disabled="true">${singleTest.dataOutStr}</textarea>
        </div>
        <HR color="#A8A8A8" size="1">
    </c:forEach>
</div>

<div style="text-align: right">
    <a class="btn dtn-default" href="<c:url value="/e-Testing/admin/EditTask.html?id=${task.id}"/>">Редактировать</a>
    <a class="btn bet-default"  onclick="return confirm('Вы действительно хотите удалить эту запись?')"
       href="<c:url value="/e-Testing/admin/DeleteTask.html?id=${task.id}&form=${task.form}"/>">Удалить</a>
</div>
</body>

</html>