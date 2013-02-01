<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<form:form method="post" action="/e-Testing/SaveProgram" commandName="program" encType="multipart/form-data">
<c:if test="${not empty student.id}">
    <input type="hidden" id="studentId" name="studentId"
           value="${student.id}"/>
</c:if>
      <div style="margin-left: 1100px">
      <c:out value="Hello, ${student.firstName} ${student.secondName}"/>
      </div>

    <form:label path="programName">Название лабораторной</form:label>
    <form:input path="programName" value="${program.programName}" cssStyle="margin-left: 100px"/><br><br>

    <c:out value="Фаил на проверку"/>
    <input type="file" value="${program.file}" name="file" style="margin-left: 140px" class="inputStyle"><br><br>

    <input type="submit" class="inputStyle" value="Отправить"/>
 </form:form>
</body>
</html>