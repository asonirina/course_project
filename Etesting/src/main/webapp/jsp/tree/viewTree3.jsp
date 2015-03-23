<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">

    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1.1", {packages:["wordtree"]});
        google.setOnLoadCallback(drawSimpleNodeChart);

        function drawSimpleNodeChart() {
            var nodeListData = new google.visualization.DataTable();
            nodeListData.addColumn('number', 'id');
            nodeListData.addColumn('string', 'childLabel');
            nodeListData.addColumn('number', 'parent');
            nodeListData.addColumn('number', 'size');
            nodeListData.addColumn('number', 'color');

        <c:forEach items="${treeNodes}" var="node">
            nodeListData.addRow([${node.id}, '${node.name}', ${node.parentId}, 1, 1]);
        </c:forEach>

        var options = {
            maxFontSize: 16,
            backgroundColor:'#e7e7e7',
            colors:['black', 'red', 'black'],
            wordtree:{
                format:'explicit',
                type:'suffix'
            }
        };

        var wordtree = new google.visualization.WordTree(document.getElementById('wordtree_explicit'));
        wordtree.draw(nodeListData, options);
        }
    </script>

</head>

<body>

<div id="wordtree_explicit"  ></div>

</body>
</html>