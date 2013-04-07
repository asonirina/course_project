<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <div style="color: red; font-size:35px"><input type="image" src="/images/error.png"><c:out
                        value="  Error!"/></div>
                <br>

                <div style="text-align: center"><c:out value="Доступ запрещен!"/></div>
            </div>
        </div>
    </div>
</div>

</div>

<div id="page-footer">
    <jsp:include page="/jsp/includes/footer.jsp"/>
</div>
</body>
</html>