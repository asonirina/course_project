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
    <script type="text/javascript">

        function highlightMatches(name) {
           var v1 = document.getElementsByName(name)[0];
            var v2 = document.getElementsByName(name)[1];

            v1.style = 'border:solid';
            v2.style = 'border:solid';
        }

        function returnBack(name) {
            var v1 = document.getElementsByName(name)[0];
            var v2 = document.getElementsByName(name)[1];

            v1.style = 'border:none';
            v2.style = 'border:none';
        }

    </script>
</head>

<body>
<%--<a onmo></a>--%>
<c:if test="${empty file1}">
    <div class="wrapper alert alert-success"> Не найдено соответствий</div>
</c:if>
<c:if test="${not empty file1}">
    <div class="wrapper">
        <span style="background-color: #FF9999">Удаление</span>   <br/>
        <span style="background-color: #99EBC2">Вставка</span>   <br/>
        <span style="background-color: #FFFFB2">Копирование или изменение</span>   <br/>
    </div>
    <div class="wrapper" style="overflow:auto; width: 2000px">

    <pre class="line-numbers" style="width: 600px; height: ${height}px;">
        <code class="language-${lang1}">
                ${file1}
        </code>
    </pre>

     <pre class="line-numbers" style="width: 600px; height: ${height}px;">
        <code class="language-${lang2}">
                ${file2}
        </code>
    </pre>

    </div>
</c:if>
</body>
</html>