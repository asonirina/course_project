<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <script type="text/javascript" src="/js/results.js"></script>
</head>
<body>
<div class="fixed-width">
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
            <div> &nbsp;
                <input type="image" value="${program.status}" src="/images/wait.png">
                </div>
            </c:if>
            <c:if test="${program.status == 'passed'}">
            <div> &nbsp;
                <input type="image" value="${program.status}" src="/images/passed.png">
                </div>
            </c:if>
            <c:if test="${program.status == 'failed'}">
            <div> &nbsp;
                <input type="image" value="${program.status}" src="/images/failed.png">
                </div>
                <c:if test="${not empty messages}">
                    <div style="margin-left: 200px; color: red;"><c:out value="Ошибка компиляции"/></div>
                    <c:forEach var="line" items="${messages}">
                        <div style="margin-left: 200px"><c:out value="${line}"/></div>
                    </c:forEach>
                </c:if>
            </c:if>
        </div>

        <c:if test="${not empty program.testResults}">
        <div class="input-group">
            <span style="width: 200px;" class="input-group-addon"><c:out value="Результаты тестов"/></span>
            <div>
                <a href="#" class="badge" style="background-color: green; color: #ffffff;">Развернуть</a>

                <div class="content">
                    <c:set var="str" value="${program.testResults}"/>
                    <c:forEach var="line" items="${fn:split(str, ';')}">
                        <c:if test="${fn:contains(line, 'passed')}">
                            <span style="color: green;">${line}</span><br/>
                        </c:if>
                        <c:if test="${!fn:contains(line, 'passed')}">
                            <span style="color: red;">${line}</span><br/>
                        </c:if>
                    </c:forEach>
                </div>

            </div>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>