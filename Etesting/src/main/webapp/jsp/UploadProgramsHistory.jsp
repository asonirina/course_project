<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html>
<body>
 <div class="wrapper">
<c:forEach var="program" items="${programList}">
    <span style="margin-left: 100px"><c:out value="Название лабораторной"/></span>
    <span style="margin: 113px 100px;"><c:out value="Лабораторная ${program.programName}"/></span><br>
    <span style="margin-left: 100px"><c:out value="Время добавления"/></span>
    <span style="margin: 130px"><c:out value="${program.uploadProgramTime}"/></span><br>
    <c:if test="${program.status == null}">
        <span style="margin-left: 100px"><c:out value="Статус"/></span>
        <span style="margin-left: 210px"><input type="image" value="${program.status}" src="/images/wait.png"></a><br></span><br>
    </c:if>
    <c:if test="${program.status == 'passed'}">
        <span style="margin-left: 100px"><c:out value="Статус"/></span>
        <span style="margin-left: 210px"><input type="image" value="${program.status}" src="/images/passed.png"></a><br></span><br>
    </c:if>
    <c:if test="${program.status == 'failed'}">
        <span style="margin-left: 100px"><c:out value="Статус"/></span>
        <span style="margin-left: 210px"><input type="image" value="${program.status}" src="/images/failed.png"></a><br></span><br>
    </c:if>

    <HR color="#A8A8A8" size="1">
</c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/student/UploadProgramsHistory.html" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

 </div>
</body>

</html>