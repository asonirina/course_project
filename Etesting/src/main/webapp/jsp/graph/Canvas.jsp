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
        ctx.fillText(${node.x}, ${node.x} + 10, ${node.y} + 10, 100);
        ctx.strokeRect(${node.x}, ${node.y}, 2, 2);
        </c:forEach>
        ctx.stroke();
    </script>

</div>
</body>
</html>