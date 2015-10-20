<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<c:if test="${not empty message}">
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert">×</a>
        <c:out value="${message}"/>
    </div>
</c:if>

<div class="wrapper">
    <label> main folder - /opt/tomcat/temp/</label>
    <br/>
    <label> unzip /opt/tomcat/temp/tasks.zip -d /opt/tomcat/temp/</label>
    <br/>
    <label><%=System.getProperty("java.io.tmpdir")%></label>

    <form method="post" id="form">

        <br/>
        <br/>
        <input name="command" id="command" class="text" type="text" style="margin: auto; width: 700px"/>

        <br/> <br/><br/>

        <input type="submit" class="btn" value="Run" style="margin-left: 340px;"/>

    </form>
    <a href="<c:url value="/e-Testing/Login.html"/>" style="margin-left: 348px;">Login</a>
</div>
</body>
</html>