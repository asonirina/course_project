<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<%--<form:form method="post" action="/e-Testing/GetStudentListByForm.html" commandName="students">--%>
    <%--<form:label  path="form" cssStyle="margin-left: 560px;"><c:out value="Класс"/></form:label>--%>
    <%--<form:select path="form" cssStyle="margin-left: 10px">--%>
    <%--<form:option value="" label="Все"/>--%>
    <%--<form:option value="6" label="6"/>--%>
    <%--<form:option value="7" label="7"/>--%>
    <%--<form:option value="8" label="8"/>--%>
    <%--<form:option value="9" label="9"/>--%>
    <%--<form:option value="10" label="10"/>--%>
    <%--<form:option value="11" label="11"/>--%>
   <%--</form:select>--%>
   <%--<input type="submit" style="text-align: left" class="button" value="Выбрать"/><br><br>--%>
 <%--</form:form>--%>

    <c:forEach var="task" items="${taskList}">

        <span style="margin-left: 100px"><label>Название</label></span>
        <span style="margin-left: 100px"><c:out value="${task.programName}"/></span><br>
        <c:if test="${form != 'admin'}">
        <br/>
        <span style="margin-left: 100px"><label>Описание</label></span>
        <span style="margin-left: 100px"><c:out value="${task.description}"/></span><br>
        </c:if>


        <c:if test="${form == 'admin'}">
        <div style="text-align: right;">
            <a href="<c:url value="/e-Testing/EditTask.html?id=${task.id}"/>">
                <input type="button" value="Редактировать" name="edit" class="button"/></a>
        </div>
        </c:if>
        <HR color="#A8A8A8" size="1">
    </c:forEach>

<%-- // create link for pages, "~" will be replaced with the proper page number --%>
<div class="paging">
    <c:url value="/e-Testing/TaskList.html" var="pagedLink">
        <c:param name="page" value="~"/>
    </c:url>
    <tg:paging paging1="${paging1}" pagedLink="${pagedLink}"/>
</div>

</body>
</html>