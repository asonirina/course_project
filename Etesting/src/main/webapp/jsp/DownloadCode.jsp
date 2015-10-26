<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/prism.css">
    <script type="text/javascript" src="/js/prism.js"></script>
</head>

<body>
<div class="wrapper" style="overflow:auto; height: 500px;">

    <pre class="line-numbers">
        <code class="language-${lang}">
            ${file}
        </code>
    </pre>

</div>
</body>
</html>