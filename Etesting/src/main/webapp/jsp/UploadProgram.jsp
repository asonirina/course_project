<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<c:if test="${not empty errors}">
<div id="output" class="errorblock">
    <c:forEach var="errors" items="${errors}">
        <c:out value="${errors}"/><br>
    </c:forEach>
</div>
</c:if>

<form:form method="post" action="/e-Testing/SaveProgram.html" commandName="program" encType="multipart/form-data">
<c:if test="${not empty student.id}">
    <input type="hidden" id="studentId" name="studentId"
           value="${student.id}"/>
</c:if>
      <div style="margin-left: 600px">
      <c:out value="Hello, ${student.firstName} ${student.secondName}"/>
      </div>

    <form:label path="programName" cssStyle="margin-left: 130px;"><c:out value="Название лабораторной"/></form:label>
    <form:select path="programName" cssStyle="margin-left: 100px">
        <form:option value="1" label="Лабораторная 1"/>
        <form:option value="2" label="Лабораторная 2"/>
        <form:option value="3" label="Лабораторная 3"/>
        <form:option value="4" label="Лабораторная 4"/>
        <form:option value="5" label="Лабораторная 5"/>
        <form:option value="6" label="Лабораторная 6"/>
        <form:option value="7" label="Лабораторная 7"/>
    </form:select><br><br>
    <%--<form:input path="programName" value="${program.programName}" cssStyle="margin-left: 100px"/><br><br>--%>

    <span style="margin-left: 130px;"></span><c:out value="Фаил на проверку"/></span>
    <input type="file" value="${program.file}" name="file" style="margin-left: 137px"><br><br>

    <div style="text-align: center;">
       <input type="submit" class="button" value="Отправить"/>
    </div>
 </form:form>
</body>
</html>