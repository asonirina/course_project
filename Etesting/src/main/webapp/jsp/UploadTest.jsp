<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="by.bsu.project.model.SpringUser" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<body>
<div class="wrapper">

        <form method="post" action="/e-Testing/student/CheckMatches.html"
                   encType="multipart/form-data" role="form">

            <div class="form-group">
                <label for="file1"><c:out value="Файл 1"/></label>
                <input type="file" id="file1" name="file1" class="form-control" required><br><br>
            </div>
            <div class="form-group">
                <label for="file2"><c:out value="Файл 2"/></label>
                <input type="file" id="file2" name="file2" class="form-control" required><br><br>
            </div>

            <div class="form-group" style="text-align: right;">
                <input type="submit" class="btn btn-default" value="Отправить"/>
            </div>
        </form>

</div>
</body>
</html>