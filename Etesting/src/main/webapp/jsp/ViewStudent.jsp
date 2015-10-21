<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <script type="text/javascript" src="/js/results.js"></script>
</head>
<body>
 <div class="fixed-width">
<div class="form-group">
    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Имя </span>
        <label style="border: none" class="form-control input"><c:out value="${student.firstName}"/></label>
    </div>
    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Фамилия </span>
        <label style="border: none" class="form-control input"><c:out value="${student.secondName}"/></label>
    </div>
    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Класс </span>
        <label style="border: none" class="form-control input"><c:out value="${student.form}"/></label>
    </div>
    <div class="input-group">
        <span style="width: 100px;" class="input-group-addon">Логин </span>
        <label style="border: none" class="form-control input"><c:out value="${student.login}"/></label>
    </div>


    <div style="text-align: right">
        <a class="btn btn-default" href="<c:url value="/e-Testing/admin/EditStudent.html?id=${student.id}"/>">Редактировать</a>
        <a  class="btn btn-default" onclick="return confirm('Вы действительно хотите удалить эту запись?')"
            href="<c:url value="/e-Testing/admin/DeleteStudent.html?id=${student.id}"/>">Удалить</a>
    </div>

    <HR color="#A8A8A8" size="1">

    <c:forEach var="program" items="${programList}">

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
            </c:if>
        </div>

        <c:if test="${not empty program.file}">

            <div class="input-group">
                <span style="width: 200px;" class="input-group-addon">Программа</span>
                <a style="border: none;" href="<c:url value="/e-Testing/admin/Download.html?programId=${program.id}"/>"
                   class="form-control">
                    <input type="image" value="${program.fileName}" src="/images/download.png"></a>
            </div>

        </c:if>

        <c:if test="${not empty program.testResults}">
            <div class="input-group">
                <span style="width: 200px;" class="input-group-addon"><c:out value="Результаты тестов"/></span>
                <div>
                    <a class="badge" style="background-color: green; color: #ffffff; height: 22px;">Развернуть</a>

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

        <HR color="#A8A8A8" size="1">
    </c:forEach>

    <div class="paging">
        <c:url value="/e-Testing/admin/ViewStudent.html?id=${student.id}" var="pagedLink">
            <c:param name="page" value="~"/>
        </c:url>
        <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
    </div>


</div>
 </div>
</body>

</html>