<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<form:form method="post" action="/e-Testing/SaveProgram.html" commandName="program" encType="multipart/form-data">
<c:if test="${not empty student.id}">
    <input type="hidden" id="studentId" name="studentId"
           value="${student.id}"/>
</c:if>
      <div style="margin-left: 600px">
      <c:out value="Hello, ${student.firstName} ${student.secondName}"/>
      </div>

    <form:label path="programName" cssStyle="margin-left: 130px;">Название лабораторной</form:label>
    <form:input path="programName" value="${program.programName}" cssStyle="margin-left: 100px"/><br><br>

    <span style="margin-left: 130px;"></span><c:out value="Фаил на проверку"/></span>
    <input type="file" value="${program.file}" name="file" style="margin-left: 136px"><br><br>

    <div style="text-align: center;">
       <input type="submit" class="button" value="Отправить"/>
    </div>
 </form:form>
</body>
</html>