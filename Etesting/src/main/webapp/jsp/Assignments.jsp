<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <script type="text/javascript">
        function createUserTask(studentId, taskId) {
            $.ajax({
                type:"POST",
                url:'/e-Testing/admin/AssignTask.html?&userId=' + studentId + '&taskId=' + taskId,
                success:function (data) {
                    document.getElementById(studentId + '_' + taskId).textContent = 'In Progress';
                    document.getElementById(studentId + '_' + taskId).className = 'yellow option';
                    document.getElementById(studentId + '_' + taskId).disabled = 'true';
                    $('#' + studentId + '_' + taskId).disabled('true');
                },
                error:function (e) {
                    alert('Something is wrong... Try later ');
                }
            });
        }
    </script>
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
                                <button disabled="true" class="yellow option">In Progress</button>
                            </td>
                        </c:if>
                        <c:if test="${status == 1}">
                            <td>
                                <button disabled="true" class="red option">Failed</button>
                            </td>
                        </c:if>
                        <c:if test="${status == 2}">
                            <td>
                                <button disabled="true" class="green badge  option ">Passed</button>
                            </td>
                        </c:if>

                        <c:if test="${status == 3}">
                            <td>
                                <button disabled="true" class="green option">Approved</button>
                            </td>
                        </c:if>

                    </c:if>
                    <c:if test="${isSet eq 'false'}">
                        <td>
                            <button id="${student.id}_${task.id}" class="white option btn"
                                    onclick="createUserTask(${student.id}, ${task.id})">+
                            </button>
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