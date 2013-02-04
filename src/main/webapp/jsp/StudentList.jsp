<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html>
<body>
    <c:forEach var="student" items="${studentList}">

        <span style="margin-left: 100px"><label>Имя</label></span>
        <span style="margin-left: 100px"><c:out value="${student.firstName}"/></span><br>
        <span style="margin-left: 100px"><label>Фамилия</label></span>
        <span style="margin-left: 69px"><c:out value="${student.secondName}"/></span><br>
        <span style="margin-left: 100px"><label>Класс</label></span>
        <span style="margin-left: 89px"><c:out value="${student.form}"/></span><br>

        <div style="text-align: right;">
            <a href="<c:url value="/e-Testing/ViewStudent.html?id=${student.id}"/>"><input type="button"
                                                                        value="Посмотреть"
                                                                        name="view" class="button"/></a>
            <a href="<c:url value="/e-Testing/EditStudent.html?id=${student.id}"/>"><input type="button"
                                                                                        value="Редактировать"
                                                                                        name="edit" class="button"/></a>
        </div>
        <HR color="#52A8E8" size="1">
    </c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/StudentList.html" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>