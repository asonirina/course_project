<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sitemesh-page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        google.load("visualization", "1", {packages:["treemap"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            // Create and populate the data table.
            var data = google.visualization.arrayToDataTable([
                ['Location', 'Parent', 'Market trade volume (size)', 'Market increase/decrease (color)'],

//                ['0', null, 5, 0],
//                ['1', '0', 5, 0],
//                ['2', '0', 5, 0],
//                ['3', '0', 5, 0],
//                ['4', '0', 5, 0],
//                ['5', '0', 5, 0]
                <c:forEach items="${treeNodes}" var="node" varStatus="status">

                [{v:'${node.id}', f:'${node.id}'+" : "+'${node.name}'}, '${node.parentId}', 1, Math.random()]

                <c:if test="${!status.last}">
                ,
                </c:if>
                </c:forEach>
            ]);

            // Create and draw the visualization.
            var tree = new google.visualization.TreeMap(document.getElementById('chart_div'));
            tree.draw(data, {
                minColor:'DeepSkyBlue',
                midColor:'SkyBlue',
                maxColor:'LightSkyBlue',
                headerHeight:15,
                fontColor:'black',
                showScale:true,
                maxDepth: 1
            });
        }
    </script>
</head>

<body>
<div id="chart_div" style="width: 750px; height: 500px;"></div>
</body>
</html>