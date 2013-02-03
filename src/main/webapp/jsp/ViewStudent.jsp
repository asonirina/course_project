<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

    <span style="margin-left: 200px"><c:out value="Имя"/></span>
    <span style="margin-left: 235px"><c:out value="${student.firstName}"/></span><br><br>
    <span style="margin-left: 200px"><c:out value="Фамилия"/></span>
    <span style="margin-left: 200px"><c:out value="${student.secondName}"/></span><br><br>
    <span style="margin-left: 200"><c:out value="Класс"/></span>
    <span style="margin-left: 223px"><c:out value="${student.form}"/></span><br><br>
    <span style="margin-left: 200px"><c:out value="Логин"/></span>
    <span style="margin-left: 220px"><c:out value="${student.login}"/></span><br><br>
    <span style="margin-left: 200px"><c:out value="Пароль"/></span>
    <span style="margin-left: 214px"><c:out value="${student.password}"/></span><br><br>
    <HR color="#52A8E8" size="1">

  <c:forEach var="program" items="${programList}">
    <span style="margin-left: 200px"><c:out value="Название лабораторной"/></span>
    <span style="margin-left: 113px;"><c:out value="${program.programName}"/></span><br><br>
    <span style="margin-left: 200px"><c:out value="Статус"/></span>
    <span style="margin-left: 213px"><c:out value="${program.status}"/></span><br><br>
    <HR color="#52A8E8" size="1">
    <%--<c:out value="Программа"/>--%>
    <%--<a href="${pageContext.request.contextPath}/Download/${program.id}"><br><br><br>--%>
  </c:forEach>

  <div style="text-align: right">
  <a href="<c:url value="/e-Testing/EditStudent.html?id=${student.id}"/>"><input type="button"
                                                                                value="Редактировать"
                                                                                name="edit" class="button"/></a>
  <a href="<c:url value="/e-Testing/DeleteStudent.html?id=${student.id}"/>"><input type="button"
                                                                  onclick="return confirm('Вы действительно хотите удалить эту запись?')"
                                                                  value="Удалить"
                                                                  name="delete" class="button"/></a>
  </div>
</body>

</html>