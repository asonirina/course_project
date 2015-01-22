<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body id="body">
<div id="page-container">
    <div id="page-header">
        <jsp:include page="/jsp/includes/header.jsp"/>
    </div>
    <div id="navigation">
        <jsp:include page="/jsp/includes/login/menu.jsp"/>
    </div>

    <div id="templatemo_content_wrapper">
        <div id="templatemo_content_top"></div>
        <div id="templatemo_content">
            <div id="content-container">
      <div style="margin-left: 100px"><input type="image" src="/images/error404.jpg"></div>
      <br>
      <a style="margin-left: 300px;" href="<c:url value="/e-Testing/Login.html"/>">На главную</a>
        </div>
    </div>
</div>
</div>

</div>

<div id="page-footer">
    <jsp:include page="/jsp/includes/footer.jsp"/>
</div>
</body>
</body>
</html>