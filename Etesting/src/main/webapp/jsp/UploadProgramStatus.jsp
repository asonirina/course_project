<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="/js/results.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/results.css">
</head>
<body>
<div class="wrapper">
            <span style="margin-left: 200px"><c:out value="Название лабораторной"/></span>
            <span style="margin-left: 113px;"><c:out value="Лабораторная ${program.programName}"/></span><br>
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
                <c:if test="${not empty messages}">
                <div style="margin-left: 200px; color: red;"><c:out value="Ошибка компиляции"/></div>
                <c:forEach var="line" items="${messages}">
                   <div style="margin-left: 200px"><c:out value="${line}"/></div>
                </c:forEach>
                </c:if>
            </c:if>

            <c:if test="${not empty program.testResults}">
                <span style="margin-left: 200px; display:inline-block;"><c:out value="Результаты тестов"/></span>
                <div class="layer" style="margin: 0 130px;">
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
</div>
</body>
</html>