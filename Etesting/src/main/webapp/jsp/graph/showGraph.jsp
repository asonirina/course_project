<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<style>
    .node {
        cursor: pointer;
    }

    .node:hover {
        stroke: #000;
        stroke-width: 1.5px;
    }

    .node--leaf {
        fill: white;
    }

    .label {
        font: 14px "Helvetica Neue", Helvetica, Arial, sans-serif;
        text-anchor: middle;
        text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, -1px 0 0 #fff, 0 -1px 0 #fff;
    }

    .label,
    .node--root,
    .node--leaf {
        pointer-events: none;
    }
</style>
</head>

<body>
<script src="http://d3js.org/d3.v3.min.js"></script>

<script>

    var margin = 0,
            diameter = 700;

    var color = d3.scale.linear()
            .domain([-1, 5])
            .range(["hsl(0, 3.2%,100%)", "hsl(0, 3.2%,  46%)"])
            .interpolate(d3.interpolateHcl);

    var pack = d3.layout.pack()
            .padding(2)
            .size([diameter - margin, diameter - margin])
            .value(function(d) { return d.size; })

    var svg = d3.select("#content-container").append("svg")
            .attr("width", diameter)
            .attr("height", diameter)
            .append("g")
            .attr("transform", "translate(" + diameter / 2 + "," + diameter / 2 + ")");


    var callJson = function (json) {
        d3.json(json, function(error, root) {
            if (error) return console.error(error);

            svg.selectAll("circle").remove();
            svg.selectAll("text").remove();

            var focus = root,
                    nodes = pack.nodes(root),
                    view;

            var circle = svg.selectAll("circle")
                    .data(nodes)
                    .enter().append("circle")
                    .attr("class", function(d) { return d.parent ? d.children ? "node" : "node node--leaf" : "node node--root"; })
                    .style("fill", function(d) { return d.children ? color(d.depth) : d.color; })
                    .on("click", function(d) { if (focus !== d) zoom(d), d3.event.stopPropagation(); });

            var text = svg.selectAll("text")
                    .data(nodes)
                    .enter().append("text")
                    .attr("class", "label")
                    .style("fill-opacity", function(d) { return d.parent === root ? 1 : 0; })
                    .style("display", function(d) { return d.parent === root ? null : "none"; })
                    .text(function(d) { return d.name; });

            var node = svg.selectAll("circle,text");

            d3.select("#content-container")
//                    .style("background", color(-1))
                    .on("click", function() { zoom(root); });

            zoomTo([root.x, root.y, root.r * 2 + margin]);

            function zoom(d) {
                var focus0 = focus; focus = d;

                var transition = d3.transition()
                        .duration(d3.event.altKey ? 7500 : 750)
                        .tween("zoom", function(d) {
                            var i = d3.interpolateZoom(view, [focus.x, focus.y, focus.r * 2 + margin]);
                            return function(t) { zoomTo(i(t)); };
                        });

                transition.selectAll("text")
                        .filter(function(d) { return d.parent === focus || this.style.display === "inline"; })
                        .style("fill-opacity", function(d) { return d.parent === focus ? 1 : 0; })
                        .each("start", function(d) { if (d.parent === focus) this.style.display = "inline"; })
                        .each("end", function(d) { if (d.parent !== focus) this.style.display = "none"; });
            }

            function zoomTo(v) {
                var k = diameter / v[2]; view = v;
                node.attr("transform", function(d) { return "translate(" + (d.x - v[0]) * k + "," + (d.y - v[1]) * k + ")"; });
                circle.attr("r", function(d) { return d.r * k; });
            }
        });
    };

    callJson("<%=request.getContextPath()%>/e-Testing/admin/GetGraph.html");

    d3.select(self.frameElement).style("height", diameter + "px");

</script>
</body>
</html>