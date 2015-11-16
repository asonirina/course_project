<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>
<div class="wrapper">

<canvas id="canvas" width="500" height="500" style="border:1px solid #000000;"></canvas>

    <script type="application/javascript">
        var canvas = document.getElementById("canvas");
        var ctx = canvas.getContext("2d");
        ctx.beginPath();
        <c:forEach items="${nodes}" var="node" varStatus="status">
        <c:if test="${node.grid}">
            var rad = 500.0 / Math.sqrt(${node.x} * ${node.x} + ${node.y} * ${node.y});
            ctx.beginPath();
            ctx.setLineDash([5, 10]);
            ctx.moveTo(0, 0);
            ctx.lineTo(rad * ${node.x}, rad * ${node.y});
            ctx.stroke();
        </c:if>
        ctx.fillRect(${node.x}, ${node.y}, 6, 6);
        </c:forEach>
        ctx.stroke();
    </script>

</div>
</body>
</html>