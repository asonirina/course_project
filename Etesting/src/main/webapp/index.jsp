<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <core:redirect url="/e-Testing/admin/MainPage.html"/>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_USER')">
    <core:redirect url="/e-Testing/student/MainPage.html"/>
</sec:authorize>

</body>

</html>