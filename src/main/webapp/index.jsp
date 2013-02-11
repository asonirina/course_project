<%@ page import="by.bsu.project.model.SpringUser" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<%
    SpringUser user = (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long id = user.getId();
    String url = "/e-Testing/MainStudentPage.html?id=" + String.valueOf(id);
%>


<sec:authorize access="hasRole('ROLE_ADMIN')">
    <core:redirect url="/e-Testing/MainAdminPage.html"/>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_USER')">
    <core:redirect url="<%=url%>"/>
</sec:authorize>

</body>

</html>