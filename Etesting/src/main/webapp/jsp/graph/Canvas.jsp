<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <script type="application/javascript">
        function draw() {
            var canvas = document.getElementById("canvas");
            var ctx = canvas.getContext("2d");
            ctx.beginPath();
//            ctx.arc(95,50,40,0,2*Math.PI);
            ctx.strokeRect(10,10,1,1);
            ctx.stroke();
        }
    </script>
</head>
<body>
<div class="wrapper">

<canvas id="canvas" width="500" height="500" style="border:1px solid #000000;"></canvas>

    <script type="application/javascript">
        var canvas = document.getElementById("canvas");
        var ctx = canvas.getContext("2d");
        ctx.beginPath();
        <c:forEach items="${nodes}" var="node" varStatus="status">
        ctx.strokeRect(${node.x}, ${node.y}, 2, 2);
        </c:forEach>
        ctx.stroke();
    </script>

</div>
</body>
</html>