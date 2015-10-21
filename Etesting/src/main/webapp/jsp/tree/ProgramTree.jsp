<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/tree.css">
</head>

<body>
<div class="wrapper">
    <script src="http://d3js.org/d3.v3.min.js"></script>

    <script>
        var data = [

            <c:forEach items="${treeNodes}" var="node" varStatus="status">

            {"name":'${node.id}' + " : " + '${node.name}', "parent":'${node.parentId}' + " : " + '${node.parentName}' }

            <c:if test="${!status.last}"> ,
            </c:if>

            </c:forEach>
        ];
    </script>
    <script src="/js/tree.js"></script>
</div>
</body>
</html>