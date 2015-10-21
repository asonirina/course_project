<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html>
<body>
<div class="fixed-width">

    <c:forEach var="program" items="${programList}">
        <div class="form-group">

            <div class="input-group">
                <span style="width: 200px;" class="input-group-addon">Название лабораторной</span>
                <label style="border: none" class="form-control input"><c:out
                        value="Лабораторная ${program.programName}"/></label>
            </div>

            <div class="input-group">
                <span style="width: 200px;" class="input-group-addon">Время добавления</span>
                <label style="border: none" class="form-control input"><c:out
                        value="${program.uploadProgramTime}"/></label>
            </div>

            <div class="input-group">
                <span style="width: 200px;" class="input-group-addon">Статус</span>
                <c:if test="${program.status == null}">
                    <input type="image" value="${program.status}" src="/images/wait.png">
                </c:if>
                <c:if test="${program.status == 'passed'}">
                    <input type="image" value="${program.status}" src="/images/passed.png">
                </c:if>
                <c:if test="${program.status == 'failed'}">
                    <input type="image" value="${program.status}" src="/images/failed.png">
                </c:if>
            </div>

            <HR color="#A8A8A8" size="1">
        </div>
    </c:forEach>

    <div class="paging">
        <c:url value="/e-Testing/student/UploadProgramsHistory.html" var="pagedLink">
            <c:param name="page" value="~"/>
        </c:url>
        <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
    </div>

</div>
</body>

</html>