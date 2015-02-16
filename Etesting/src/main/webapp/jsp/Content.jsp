<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<table>

    <c:forEach var="n" varStatus="loop" items="${news}">
        <tr>
            <td colspan="2" style="text-align: right; font-size: 11px">${n.date}</td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: left">
                <a href="${n.url}">
                    <b style="font-size: 16px">${n.title}</b>
                </a>
                <br/>  <br/>
            </td>
        </tr>

        <tr>
            <td>
                <a class="imagelink" title="${n.title}" href="${n.url}">
                    <c:if test="${not empty n.imageUrl}">
                        <img class="narrow" src="${n.imageUrl}"/>
                    </c:if>
                    <c:if test="${empty n.imageUrl}">
                        <img class="narrow" src="/images/no_image.png"/>
                    </c:if>
                </a>
            </td>
            <td style="padding: 0 50px;">
                ${n.content}
            </td>
        </tr>

        <c:if test="${!loop.last}">
        <tr>
            <td colspan="2" style="text-align: right; font-size: 11px">
                <HR color="#A8A8A8" size="1">
            </td>
        </tr>
        </c:if>

         </c:forEach>

</table>

</body>