<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <decorator:head/>
</head>

<body id="body">

<div id="page-container">
    <div id="page-header"><jsp:include page="/jsp/includes/header.jsp"/></div>
    <div id="navigation"><jsp:include page="/jsp/includes/student/menu.jsp"/></div>

    <div id="templatemo_content_wrapper">
        <div id="templatemo_content_top"></div>
        <div id="templatemo_content">
            <div id="content-container"><decorator:body /></div>
        </div></div></div>
<div id="page-footer"><jsp:include page="/jsp/includes/footer.jsp"/></div>

</body>
</html>

