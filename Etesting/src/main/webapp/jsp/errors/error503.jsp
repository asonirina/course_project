<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<div style="color: red; font-size:35px"><input type="image" src="/images/error.png"><c:out value="  Error!"/></div>
<br/>

<div style="text-align: center"><c:out value="Произошла ошибка на сервере.
      Обратитесь за дополнительной информацией к системному администратору!"/>
    <br/>
    <a href="<c:url value="/e-Testing/Login.html"/>">На главную</a>
</div>
    <p>${errors}</p>
</body>
</html>