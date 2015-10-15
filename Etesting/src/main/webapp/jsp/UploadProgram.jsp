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

<c:if test="${empty tasks}">
    <p style="margin-left: 230px">На данный момент нет лабораторных работ</p>
</c:if>

<c:if test="${not empty tasks}">

<form:form method="post" action="/e-Testing/student/SaveProgram.html" commandName="program" encType="multipart/form-data">
<c:if test="${not empty student.id}">
    <input type="hidden" id="studentId" name="studentId"
           value="${student.id}"/>
</c:if>
      <div style="margin-left: 600px">
      <c:out value="Hello, ${student.firstName} ${student.secondName}"/>
      </div>

    <form:label path="programName" cssStyle="margin-left: 130px;"><c:out value="Название лабораторной"/></form:label>
    <form:select path="programName" cssStyle="margin-left: 100px">

        <c:forEach var="task" items="${tasks}">
            <form:option value="${task.programName}" label="Лабораторная ${task.programName}"/>
        </c:forEach>

    </form:select><br><br>

    <span style="margin-left: 130px;"></span><c:out value="Фаил на проверку"/></span>
    <input type="file" value="${program.file}" name="file" style="margin-left: 137px"><br><br>

    <div style="text-align: center;">
       <input type="submit" class="button" value="Отправить"/>
    </div>
 </form:form>

</c:if>

</body>
</html>