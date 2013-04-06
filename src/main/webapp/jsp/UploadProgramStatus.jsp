<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
            <span style="margin-left: 200px"><c:out value="Название лабораторной"/></span>
            <span style="margin-left: 113px;"><c:out value="Лабораторная ${program.programName}"/></span><br>
            <span style="margin-left: 200px"><c:out value="Время добавления"/></span>
            <span style="margin-left: 146px"><c:out value="${program.uploadProgramTime}"/></span><br>
            <c:if test="${program.status == 'passed'}">
                <span style="margin-left: 200px"><c:out value="Статус"/></span>
                <span style="margin-left: 217px"><input type="image" value="${program.status}" src="/images/passed.png"></a><br></span><br>
            </c:if>
            <c:if test="${program.status == 'failed'}">
                <span style="margin-left: 200px"><c:out value="Статус"/></span>
                <span style="margin-left: 217px"><input type="image" value="${program.status}" src="/images/failed.png"></a><br></span><br>
                <c:if test="${not empty messages}">
                <div style="margin-left: 200px; color: red;"><c:out value="Ошибка компиляции"/></div>
                <c:forEach var="line" items="${messages}">
                   <div style="margin-left: 200px"><c:out value="${line}"/></div>
                </c:forEach>
                </c:if>
            </c:if>

</body>
</html>