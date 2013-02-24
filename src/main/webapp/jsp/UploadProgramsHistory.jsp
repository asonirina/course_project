<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html>
<body>

<c:forEach var="program" items="${programList}">
    <span style="margin-left: 200px"><c:out value="Название лабораторной"/></span>
    <span style="margin-left: 113px;"><c:out value="${program.programName}"/></span><br>
    <span style="margin-left: 200px"><c:out value="Время добавления"/></span>
    <span style="margin-left: 146px"><c:out value="${program.uploadProgramTime}"/></span><br>
    <span style="margin-left: 200px"><c:out value="Статус"/></span>
    <span style="margin-left: 217px"><c:out value="${program.status}"/></span><br>

    <HR color="#52A8E8" size="1">
</c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/UploadProgramsHistory.html" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

<div style="text-align: right">
</div>
</body>

</html>