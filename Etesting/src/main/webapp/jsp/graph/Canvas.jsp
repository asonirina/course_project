<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.5/js/bootstrap-dialog.min.js"></script>
</head>
<body>
<div class="wrapper">

<canvas id="canvas" width="500" height="500" style="border:1px solid #000000;"></canvas>

    <script type="application/javascript">
        var canvas = document.getElementById("canvas");
        var ctx = canvas.getContext("2d");

        var Links = new Array();
        var id = "";
        ctx.fillStyle = "#0000ff";

        ctx.textBaseline = "top";


        function drawLink(x,y,href){
            ctx.beginPath();
            ctx.fillRect(x, y, 6, 6);
            ctx.lineWidth = 1;
            ctx.strokeStyle = 'blue';
            ctx.stroke();

            canvas.addEventListener("mousemove", on_mousemove, true);
            canvas.addEventListener("click", on_click, true);

            Links.push(x + ";" + y + ";" + href);
        }

        function getMousePos(canvas, evt) {
            var rect = canvas.getBoundingClientRect();
            return {
                x: evt.clientX - rect.left,
                y: evt.clientY - rect.top
            };
        }

        function on_mousemove (ev) {
            var x = getMousePos(canvas, ev).x, y = getMousePos(canvas, ev).y;

            for (var i = Links.length - 1; i >= 0; i--) {
                var params = new Array();

                params = Links[i].split(";");

                var     linkX = parseInt(params[0]),
                        linkY = parseInt(params[1]),
                        linkHref = params[2];

                if (x >= linkX && x <= (linkX + 6) && y >= linkY && y <= (linkY + 6)){
                    document.body.style.cursor = "pointer";
                    id = linkHref;
                    break;
                }
                else {
                    document.body.style.cursor = "";
                    id = "";
                }
            }
        }

        function on_click(e) {
            if (id){
                $.ajax({
                    url:'/e-Testing/admin/GetACInfo.html',
                    type:'GET',
                    dataType:'json',
                    contentType:'application/json',
                    mimeType:'application/json',
                    data:({
                        acId: id
                    }),
                    success:function (data) {
                        var d = document.createElement('div');
                        d.setAttribute('id', 'program_info');
                        d.innerHTML =
                                '<div class="form-group wrapper"> ' +
                                    '<div class="input-group">' +
                                        '<span style="width: 150px;" class=\"input-group-addon">Студент</span>' +
                                        '<label id="name" style="border: none" class="form-control input">' + data.name + '</label>' +
                                    '</div> ' +
                                '</div>';

                        document.body.appendChild(d);
                        showDialog();
                    },
                    error:function (e) {
                        dialog.close();
                        alert('Something is wrong... Try later ' + e);
                    }
                });

                function showDialog() {
                    BootstrapDialog.show({
                        title:'Upload Program Info',
                        message:$('#program_info'),
                        buttons:[
                            {
                                label:'Close',
                                action:function (dialog) {
                                    dialog.close();
                                }
                            }
                        ]
                    });
                }
            }
        }



        <c:forEach items="${nodes}" var="node" varStatus="status">
        <c:if test="${node.grid}">
            ctx.beginPath();
            ctx.setLineDash([5, 10]);
            ctx.moveTo(0, 0);
            ctx.lineTo(${node.x}, ${node.y});
            ctx.strokeStyle = 'black';
            ctx.stroke();
        </c:if>
        drawLink( ${node.x}, ${node.y} ,${node.acId});
        </c:forEach>

    </script>

</div>
</body>
</html>