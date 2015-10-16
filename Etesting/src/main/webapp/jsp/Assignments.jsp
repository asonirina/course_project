<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="/js/results.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/results.css">
</head>
<body>
<div class="wrapper">
<div class="layer" style="float: left">
    <p class="button heading">Классы: ${currentForm}</p>

    <div class="content" style="background: none">
        <a class="white-option button" href="<c:url value="/e-Testing/admin/Assignments.html?form=6"/>">6</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/Assignments.html?form=7"/>">7</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/Assignments.html?form=8"/>">8</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/Assignments.html?form=9"/>">9</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/Assignments.html?form=10"/>">10</a>
        <a class="white-option button" href="<c:url value="/e-Testing/admin/Assignments.html?form=11"/>">11</a>
    </div>
</div>
<br/>
<br/>
<table  border="1">
    <thead>
    <tr>
        <td></td>
        <c:forEach items="${tasks}" var="task">
               <td style="text-align: center">${task.programName}</td>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.secondName} ${student.firstName}</td>
            <c:forEach items="${tasks}" var="task">
                <td>
                    <input class="white-option" type="submit"  value="Add"/>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>