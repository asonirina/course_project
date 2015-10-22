<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.5/js/bootstrap-dialog.min.js"></script>
    <script type="text/javascript" src="/js/task_action.js"></script>
</head>
<body>
<div class="wrapper">

    <div class="dropdown">
        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Классы: ${currentForm}
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="<c:url value="/e-Testing/admin/Assignments.html?form=6"/>">6</a></li>
            <li><a href="<c:url value="/e-Testing/admin/Assignments.html?form=7"/>">7</a></li>
            <li><a href="<c:url value="/e-Testing/admin/Assignments.html?form=8"/>">8</a></li>
            <li><a href="<c:url value="/e-Testing/admin/Assignments.html?form=9"/>">9</a></li>
            <li><a href="<c:url value="/e-Testing/admin/Assignments.html?form=10"/>">10</a></li>
            <li><a href="<c:url value="/e-Testing/admin/Assignments.html?form=11"/>">11</a></li>
        </ul>
    </div>

    <br/>
    <table class="table table-hover">
        <thead>
        <tr>
            <td></td>
            <c:forEach items="${tasks}" var="task">
                <td style="text-align: center">${task.programName}</td>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${studentList}" varStatus="status">
            <tr>
                <td>${student.secondName} ${student.firstName}</td>
                <c:forEach items="${tasks}" var="task">
                    <c:set var="isSet" value="false"/>
                    <c:set var="status" value="-1"/>
                    <c:forEach items="${student.userTasks}" var="userTask">

                        <c:if test="${task.id == userTask.task.id}">
                            <c:set var="isSet" value="true"/>
                            <c:set var="status" value="${userTask.status}"/>
                        </c:if>

                    </c:forEach>
                    <c:if test="${isSet eq 'true'}">
                        <c:if test="${status == 0}">
                            <td>
                                <a  style="color: #000000; font-size: 19px;" class="white label option disabled">☑</a>
                            </td>
                        </c:if>
                        <c:if test="${status == 1}">
                            <td>
                                <a class="label label-danger option disabled">&nbsp;&nbsp;✖&nbsp;&nbsp;</a>
                            </td>
                        </c:if>
                        <c:if test="${status == 2}">
                            <td>
                                <a id="${student.id}_${task.id}" onclick="approveTask(${student.id}, ${task.id})" class="label label-success  option ">&nbsp;&nbsp;✓&nbsp;&nbsp;</a>
                            </td>
                        </c:if>

                        <c:if test="${status == 3}">
                            <td>
                                <a class="label label-primary option disabled">&nbsp;&nbsp;✔&nbsp;&nbsp;</a>
                            </td>
                        </c:if>

                        <c:if test="${status == 4}">
                            <td>
                                <a class="label label-default option disabled">&nbsp;&nbsp;✘&nbsp;&nbsp;</a>
                            </td>
                        </c:if>

                    </c:if>
                    <c:if test="${isSet eq 'false'}">
                        <td>
                            <a id="${student.id}_${task.id}" style=" color: #000000; font-size: 19px;" class="white label option"
                                    onclick="createUserTask(${student.id}, ${task.id})">☐
                            </a>
                        </td>
                    </c:if>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>