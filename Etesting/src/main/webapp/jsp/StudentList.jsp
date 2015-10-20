<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Классы: ${currentForm}
        <span class="caret"></span></button>
    <ul class="dropdown-menu">
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html"/>">Все</a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html?form=6"/>">6</a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html?form=7"/>">7</a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html?form=8"/>">8</a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html?form=9"/>">9</a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html?form=10"/>">10</a></li>
        <li><a href="<c:url value="/e-Testing/admin/StudentList.html?form=11"/>">11</a></li>
    </ul>
</div>
<br/>
    <c:forEach var="student" items="${studentList}">
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

        <div style="text-align: right;">
            <a href="<c:url value="/e-Testing/admin/ViewStudent.html?id=${student.id}"/>">
                <input type="button" value="Посмотреть" name="view" class="btn btn-default"/></a>
            <a href="<c:url value="/e-Testing/admin/EditStudent.html?id=${student.id}"/>">
                <input type="button" value="Редактировать" name="edit" class="btn btn-default"/></a>
        </div>

        </div>
        <HR color="#A8A8A8" size="1">
    </c:forEach>

<div class="paging">
    <c:url value="/e-Testing/admin/StudentList.html" var="pagedLink">
        <c:param name="page" value="~"/>
        <c:param name="form" value="${currentForm}"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>