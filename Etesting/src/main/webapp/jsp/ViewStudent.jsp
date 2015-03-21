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

<span style="margin-left: 200px"><c:out value="Имя"/></span>
<span style="margin-left: 228px"><c:out value="${student.firstName}"/></span><br>
<span style="margin-left: 200px"><c:out value="Фамилия"/></span>
<span style="margin-left: 199px"><c:out value="${student.secondName}"/></span><br>
<span style="margin-left: 200px"><c:out value="Класс"/></span>
<span style="margin-left: 220px"><c:out value="${student.form}"/></span><br>
<span style="margin-left: 200px"><c:out value="Логин"/></span>
<span style="margin-left: 218px"><c:out value="${student.login}"/></span><br>
<HR color="#A8A8A8" size="1">

<c:forEach var="program" items="${programList}">
    <span style="margin-left: 200px"><c:out value="Название лабораторной"/></span>
    <span style="margin-left: 113px;"><c:out value="${program.programName}"/></span><br>
    <span style="margin-left: 200px"><c:out value="Время добавления"/></span>
    <span style="margin-left: 146px"><c:out value="${program.uploadProgramTime}"/></span><br>
    <c:if test="${program.status == null}">
        <span style="margin-left: 200px"><c:out value="Статус"/></span>
        <span style="margin-left: 225px"><input type="image" value="${program.status}" src="/images/wait.png"></a><br></span><br>
    </c:if>
    <c:if test="${program.status == 'passed'}">
        <span style="margin-left: 200px"><c:out value="Статус"/></span>
        <span style="margin-left: 225px"><input type="image" value="${program.status}" src="/images/passed.png"></a><br></span><br>
    </c:if>
    <c:if test="${program.status == 'failed'}">
        <span style="margin-left: 200px"><c:out value="Статус"/></span>
        <span style="margin-left: 225px"><input type="image" value="${program.status}" src="/images/failed.png"></a><br></span><br>
    </c:if>
    <c:if test="${not empty program.file}">
        <span style="margin-left: 200px"><c:out value="Программа"/></span>
        <a href="<c:url value="/e-Testing/Download.html?programId=${program.id}"/>" style="margin-left: 193px;">
            <input type="image" value="${program.fileName}" src="/images/download.png"></a><br>
    </c:if>
    <c:if test="${not empty program.treeContent}">
        <span style="margin-left: 200px"><c:out value="Схема программы"/></span>
        <a href="<c:url value="/e-Testing/viewTree.html?programId=${program.id}"/>" style="margin-left: 150px;">
            <input  type="image" value="${program.fileName}" src="/images/tree.png"></a><br>
    </c:if>
    <c:if test="${not empty program.testResults}">
        <span style="margin-left: 200px; display:inline-block;"><c:out value="Результаты тестов"/></span>
        <div class="layer">
            <p class="heading">Развернуть</p>

            <div class="content">
                <c:set var="str" value="${program.testResults}"/>
                <c:forEach var="line" items="${fn:split(str, ';')}">
                    <c:if test="${fn:contains(line, 'passed')}">
                        <span style="color: green;">${line}</span><br/>
                    </c:if>
                    <c:if test="${!fn:contains(line, 'passed')}">
                        <span style="color: #ff4102;">${line}</span><br/>
                    </c:if>
                </c:forEach>
            </div>

        </div>
    </c:if>

    <c:if test="${not empty program.plagiat1}">
        <span style="margin-left: 200px"><c:out value="Степень похожести 1"/></span>
        <span style="margin-left: 146px"><c:out value="${program.plagiat1} %"/></span><br>
    </c:if>

    <c:if test="${not empty program.plagiat2}">
        <span style="margin-left: 200px"><c:out value="Степень похожести 2"/></span>
        <span style="margin-left: 146px"><c:out value="${program.plagiat2} %"/></span><br>
    </c:if>

    <HR color="#A8A8A8" size="1">
</c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/ViewStudent.html?id=${student.id}" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

<div style="text-align: right">
    <a href="<c:url value="/e-Testing/EditStudent.html?id=${student.id}"/>"><input type="button"
                                                                                   value="Редактировать"
                                                                                   name="edit" class="button"/></a>
    <a href="<c:url value="/e-Testing/DeleteStudent.html?id=${student.id}"/>"><input type="button"
                                                                                     onclick="return confirm('Вы действительно хотите удалить эту запись?')"
                                                                                     value="Удалить"
                                                                                     name="delete" class="button"/></a>
</div>
</body>

</html>