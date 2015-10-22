<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="by.bsu.project.model.SpringUser" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<body>
<div class="wrapper">
    <c:if test="${not empty errors}">
        <div class="alert alert-danger fade in">
            <a class="close" data-dismiss="alert">×</a>
            <c:forEach var="err" items="${errors}">
                <c:out value="${err}"/><br>
            </c:forEach>
        </div>
    </c:if>


    <c:if test="${empty student.userTasks}">
        <p style="margin-left: 230px">На данный момент нет лабораторных работ</p>
    </c:if>

    <c:if test="${not empty student.userTasks}">

        <form:form method="post" action="/e-Testing/student/SaveProgram.html" commandName="program"
                   encType="multipart/form-data" role="form">
            <c:if test="${not empty student.id}">
                <input type="hidden" id="studentId" name="studentId"
                       value="${student.id}"/>
            </c:if>
            <div class="form-group">

                <form:label path="programName"><c:out value="Название лабораторной"/></form:label>
                <form:select path="programName" class="form-control">

                    <c:forEach var="task" items="${student.userTasks}">
                        <form:option value="${task.task.programName}" label="Лабораторная ${task.task.programName}"/>
                    </c:forEach>

                </form:select><br><br>

            </div>

            <div class="form-group">
                <form:label path="file"><c:out value="Фаил на проверку"/></form:label>
                <input type="file" value="${program.file}" name="file" class="form-control" required><br><br>
            </div>
            <div class="form-group" style="text-align: right;">
                <input type="submit" class="btn btn-default" value="Отправить"/>
            </div>
        </form:form>

    </c:if>
</div>
</body>
</html>