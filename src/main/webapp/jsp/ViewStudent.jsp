<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <c:out value="Имя"/>
    <span style="margin-left: 235px"><c:out value="${student.firstName}"/></span><br><br>
    <c:out value="Фамилия"/>
    <span style="margin-left: 200px"><c:out value="${student.secondName}"/></span><br><br>
    <c:out value="Класс"/>
    <span style="margin-left: 223px"><c:out value="${student.form}"/></span><br><br>
    <c:out value="Логин"/>
    <span style="margin-left: 220px"><c:out value="${student.login}"/></span><br><br>
    <c:out value="Пароль"/>
    <span style="margin-left: 214px"><c:out value="${student.password}"/></span><br><br>

  <c:forEach var="program" items="${programList}">
    <c:out value="Название лабораторной"/>
    <span style="margin-left: 100px"><c:out value="${program.programName}"/></span><br><br>
    <c:out value="Статус"/>
    <span style="margin-left: 216px"><c:out value="${program.status}"/></span><br><br>
    <%--<c:out value="Программа"/>--%>
    <%--<a href="${pageContext.request.contextPath}/Download/${program.id}"><br><br><br>--%>
  </c:forEach>

  <a href="<c:url value="/e-Testing/EditStudent?id=${student.id}"/>"><input type="button"
                                                                                value="Редактировать"
                                                                                name="edit" class="inputStyle"/></a>
  <a href="<c:url value="/e-Testing/DeleteStudent?id=${student.id}"/>"><input type="button"
                                                                  onclick="return confirm('Вы действительно хотите удалить эту запись?')"
                                                                  value="Удалить"
                                                                  name="delete" class="inputStyle"/></a>
  <a href="<c:url value="/e-Testing/StudentList"/>"><input type="button" value="На главную" class="inputStyle"/></a><br>
</body>

</html>